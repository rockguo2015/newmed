package edu.fudan.langlab.gxt.client.component.form.factory;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider.ContentChangedListener;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ISingleValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;

public class ListGridSelector<T> implements ISingleValueSelector<T>,
		ObjectSelectionProvider<T> {

	private GXTGridComponent<T> objectListView;
	private FieldLabel fieldLabel;
	private ContentProvider<T> provider;
	private Boolean isRequired;
	private String id;
	private String title;

	public ListGridSelector(String id, final String title, Boolean isRequired,
			GXTGridComponent<T> objectListView) {
		this.objectListView = objectListView;
		this.isRequired = isRequired;
		this.id = id;
		this.title = title;

	}

	@Override
	public void setContentProvider(final ContentProvider<T> p) {
		this.provider = p;
		provider.addContentChangedListener(new ContentChangedListener() {

			@Override
			public void onContentChanged() {
				objectListView.setObjects(provider.getContents());
			}
		});
//		objectListView.setObjects(provider.getContents());

	}

	@Override
	public T getValue() {
		return IterableExtensions.head(objectListView.getSelectedObjects());
	}

	@Override
	public void addValueChangedListener(final ValueChangedListener<T> listener) {
		objectListView
				.addSelectionChangedListener(new SelectionChangedListener<T>() {

					@Override
					public void selectionChanged(Iterable<T> selections) {
						listener.onValueChanged(IterableExtensions
								.head(selections));

					}
				});

	}

	@Override
	public IValueViewer<T> setValue(T value) {
		objectListView.select(value);
		return this;
	}

	@Override
	public FieldLabel asWidget() {
		if (fieldLabel == null) {
			if (isRequired) {
				fieldLabel = new FieldLabel(objectListView.asWidget());
				fieldLabel.setHTML(Forms.toRequiredTitle(title));
			} else
				fieldLabel = new FieldLabel(objectListView.asWidget(), title);
		}

		return fieldLabel;
	}

	@Override
	public Iterable<T> getSelectedObjects() {
		return objectListView.getSelectedObjects();
	}

	@Override
	public void deselect() {
		objectListView.deselect();
	}

	@Override
	public void select(T item) {
		objectListView.select(item);
	}

	@Override
	public void addSelectionChangedListener(
			com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener<T> listener) {
		objectListView.addSelectionChangedListener(listener);

	}

}
