package edu.fudan.langlab.gxt.client.component.form.factory;

import java.util.Collection;

import com.google.common.collect.Lists;
import com.google.gwt.cell.client.TextCell;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import edu.fudan.langlab.gxt.client.widget.dualist.DualListField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ILabelProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IMultiValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class DualListMultiSelector<T> implements IMultiValueSelector<T> {

	private DualListField<T, String> field;
	private FieldLabel label;
	private IObjectNameProvider nameProvider;
	private ListStore<T> contents;
	private ListStore<T> values;
	private ILabelProvider<T> labelProvider;

	public DualListMultiSelector(String id, final String title,
			Boolean isRequired, RuntimeGinjector runtimeGinjector) {
		nameProvider = runtimeGinjector.getObjectNameProvider();
		contents = new ListStore<T>(new KeyProviderAdaptor<T>(nameProvider));
		values = new ListStore<T>(new KeyProviderAdaptor<T>(nameProvider));

		field = new DualListField<T, String>(contents, values,
				new ValueProvider<T, String>() {

					@Override
					public String getValue(T object) {
						if(labelProvider!=null) return labelProvider.getLabel(object);
						else return nameProvider.getName(object);
					}

					@Override
					public void setValue(T object, String value) {

					}

					@Override
					public String getPath() {
						return null;
					}
				}, new TextCell());

		if (isRequired) {
			label = new FieldLabel(field);
			label.setHTML(Forms.toRequiredTitle(title));
		} else
			label = new FieldLabel(field, title);

	}

	@Override
	public Collection<T> getValue() {
		return Lists.newArrayList(values.getAll());
	}

	@Override
	public void addValueChangedListener(
			ValueChangedListener<Collection<T>> listener) {

	}
	
	public void setLabelProvider(ILabelProvider<T> labelProvider){
		this.labelProvider = labelProvider;
	}

	@Override
	public void setValue(Collection<T> value) {
		if (value == null)
			value = Lists.newArrayList();
		values.clear();
		values.addAll(value);

		for (T v : value) {
			contents.remove(v);
		}
	}

	@Override
	public FieldLabel asWidget() {
		return label;
	}

	@Override
	public void setContentProvider(final ContentProvider<T> provider) {

		updateContents(provider);

		provider.addContentChangedListener(new ContentChangedListener() {

			@Override
			public void onContentChanged() {
				updateContents(provider);

			}
		});
	}

	private void updateContents(ContentProvider<T> provider) {
		for (T item : provider.getContents()) {
			contents.add(item);
		}
	}
}
