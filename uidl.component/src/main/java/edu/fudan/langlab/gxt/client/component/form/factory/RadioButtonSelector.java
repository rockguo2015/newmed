package edu.fudan.langlab.gxt.client.component.form.factory;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.form.AdapterField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.Radio;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ISingleValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class RadioButtonSelector<T> implements ISingleValueSelector<T> {

	private HorizontalPanel con = new HorizontalPanel();
	private IObjectNameProvider nameProvider;

	public RadioButtonSelector(String id, final String title,
			Boolean isRequired, RuntimeGinjector runtimeGinjector) {
		nameProvider = runtimeGinjector.getObjectNameProvider();

		AdapterField<T> field = new AdapterField<T>(con) {

			@Override
			public void setValue(T value) {
				RadioButtonSelector.this.setValue(value);
			}

			@Override
			public T getValue() {
				return RadioButtonSelector.this.getValue();
			}
		};
		if (isRequired) {
			label = new FieldLabel(field);
			label.setHTML(Forms.toRequiredTitle(title));
		} else
			label = new FieldLabel(field, title);

	}

	BiMap<T, HasValue<Boolean>> radios = HashBiMap.create();
	ToggleGroup group = new ToggleGroup();

	FieldLabel label;

	@Override
	public void setContentProvider(ContentProvider<T> provider) {
		group.clear();
		radios.clear();
		con.clear();
		for (T item : provider.getContents()) {
			Radio r = new Radio();
			r.setBoxLabel(nameProvider.getName(item));
			con.add(r);
			group.add(r);
			radios.put(item, r);
		}

	}

	@Override
	public T getValue() {
		return radios.inverse().get(group.getValue());
	}

	@Override
	public void addValueChangedListener(final ValueChangedListener<T> listener) {
		group.addValueChangeHandler(new ValueChangeHandler<HasValue<Boolean>>() {
			@Override
			public void onValueChange(ValueChangeEvent<HasValue<Boolean>> event) {
				listener.onValueChanged(radios.inverse().get(event.getValue()));
			}
		});
	}

	@Override
	public IValueViewer<T> setValue(T value) {
		group.setValue(radios.get(value));
		return this;
	}

	@Override
	public FieldLabel asWidget() {
		return label;
	}
}
