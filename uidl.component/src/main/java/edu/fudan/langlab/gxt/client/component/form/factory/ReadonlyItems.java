package edu.fudan.langlab.gxt.client.component.form.factory;

import java.util.Collection;

import javax.annotation.Nullable;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.gwt.user.client.ui.HTML;
import com.sencha.gxt.widget.core.client.form.AdapterField;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValuesProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class ReadonlyItems<T> implements IValuesProvider<T> {
	private HTML content;
	private FieldLabel fieldLabel;
	private Collection<T> value;

	IObjectNameProvider nameProvider;

	public ReadonlyItems(String id, String title,
			IObjectNameProvider nameProvider) {
		this.nameProvider = nameProvider;
		AdapterField<Collection<T>> field = new AdapterField<Collection<T>>(
				content = new HTML()) {

			@Override
			public void setValue(Collection<T> value) {
				ReadonlyItems.this.setValue(value);
			}

			@Override
			public Collection<T> getValue() {
				return ReadonlyItems.this.getValue();
			}
		};

		fieldLabel = new FieldLabel(field, title);
	}

	@Override
	public void setValue(Collection<T> value) {
		this.value = value;
		content.setHTML("<i><u>" + toString(value) + "</u></i>");
	}

	@Override
	public Collection<T> getValue() {
		return value;
	}

	protected String toString(Collection<T> value) {
		Iterable<String> stringValue = Iterables.transform(value,
				new Function<T, String>() {

					@Override
					@Nullable
					public String apply(@Nullable T arg0) {
						return nameProvider.getName(arg0);
					}
				});
		return IterableExtensions.join(stringValue, ",");

	}

	@Override
	public FieldLabel asWidget() {

		return fieldLabel;
	}

	@Override
	public void addValueChangedListener(
			ValueChangedListener<Collection<T>> listener) {
		// TODO Auto-generated method stub

	}
}