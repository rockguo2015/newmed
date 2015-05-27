package edu.fudan.langlab.gxt.client.component.form.factory;

import java.util.Collection;

import javax.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.sencha.gxt.widget.core.client.form.AdapterField;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.ContentProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IMultiValueSelector;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class CheckBoxMultiSelector<T> implements IMultiValueSelector<T> {

	private HorizontalPanel con = new HorizontalPanel();
	private IObjectNameProvider nameProvider;
	private String title;

	public CheckBoxMultiSelector(String id, final String title,
			RuntimeGinjector runtimeGinjector) {
		nameProvider = runtimeGinjector.getObjectNameProvider();
		this.title = title;
	}

	BiMap<T, HasValue<Boolean>> checkboxes = HashBiMap.create();
	FieldLabel label;

	@Override
	public Collection<T> getValue() {
		Iterable<HasValue<Boolean>> selectedCheckboxes = Iterables.filter(
				checkboxes.values(), new Predicate<HasValue<Boolean>>() {

					@Override
					public boolean apply(@Nullable HasValue<Boolean> input) {
						return input.getValue();
					}
				});
		Iterable<T> values = Iterables.transform(selectedCheckboxes,
				new Function<HasValue<Boolean>, T>() {

					@Override
					@Nullable
					public T apply(@Nullable HasValue<Boolean> input) {
						return checkboxes.inverse().get(input);
					}
				});
		return Lists.newArrayList(values);
	}

	@Override
	public void addValueChangedListener(
			final ValueChangedListener<Collection<T>> listener) {
		for (HasValue<Boolean> item : checkboxes.values()) {
			item.addValueChangeHandler(new ValueChangeHandler<Boolean>() {

				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {
					listener.onValueChanged(getValue());

				}
			});
		}
	}

	@Override
	public void setValue(Collection<T> values) {
		for (HasValue<Boolean> checkbox : checkboxes.values()) {
			checkbox.setValue(false);
		}
		for (T item : values) {
			HasValue<Boolean> checkbox = checkboxes.get(item);
			checkbox.setValue(true);
		}
	}

	@Override
	public FieldLabel asWidget() {
		if (label == null) {
			AdapterField<Collection<T>> field = new AdapterField<Collection<T>>(
					con) {

				@Override
				public void setValue(Collection<T> value) {

					CheckBoxMultiSelector.this.setValue(value);
				}

				@Override
				public Collection<T> getValue() {
					return CheckBoxMultiSelector.this.getValue();
				}
			};
			label = new FieldLabel(field, title);
		}
		return label;
	}

	@Override
	public void setContentProvider(ContentProvider<T> provider) {
		checkboxes.clear();
		con.clear();
		for (T item : provider.getContents()) {
			CheckBox r = new CheckBox();
			r.setBoxLabel(nameProvider.getName(item));
			con.add(r);
			checkboxes.put(item, r);
		}
	}
}
