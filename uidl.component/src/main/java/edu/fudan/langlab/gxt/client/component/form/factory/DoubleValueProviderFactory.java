package edu.fudan.langlab.gxt.client.component.form.factory;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.NumberInputCell;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.DoublePropertyEditor;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

import edu.fudan.langlab.gxt.client.component.form.factory.StringValueProviderFactory.TextItem;

public class DoubleValueProviderFactory {

	public static class DoubleItem implements IValueProvider<Double> {

		private NumberField<Double> doubleField;
		private FieldLabel fieldLabel;

		public DoubleItem(String id, String title, Boolean isRequired) {
			DoublePropertyEditor de = new DoublePropertyEditor();
			if (isRequired) {
				fieldLabel = new FieldLabel(
						doubleField = new NumberField<Double>(
								new NumberInputCell<Double>(de), de));
				fieldLabel.setHTML(Forms.toRequiredTitle(title));
			} else {
				fieldLabel = new FieldLabel(
						doubleField = new NumberField<Double>(
								new NumberInputCell<Double>(de), de), title);
			}
			doubleField.setAllowNegative(true);
		}

		@Override
		public IValueViewer<Double> setValue(Double value) {
			doubleField.setValue(value);
			return this;
		}

		public FieldLabel asReadonlyWidget() {
			doubleField.setReadOnly(true);
			return fieldLabel;
		}
		
		
		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public Double getValue() {
			return doubleField.getValue();
		}

		public void focus(){
			doubleField.focus();
		}
		
		public Widget getField(){
			return doubleField;
		}
		
		@Override
		public void addValueChangedListener(
				final ValueChangedListener<Double> listener) {
			doubleField.addValueChangeHandler(new ValueChangeHandler<Double>() {

				@Override
				public void onValueChange(ValueChangeEvent<Double> event) {
					listener.onValueChanged(event.getValue());

				}
			});

		}
	}

	@WidgetProvider(isDefault = true)
	public DoubleItem createAsDoubleItem(String id, String title) {
		return new DoubleItem(id, title,false);
	}
	@WidgetProvider(isDefault = true)
	public DoubleItem createAsRequiredDoubleItem(String id, String title) {
		return new DoubleItem(id, title,true);
	}

	public static class DoubleReadonlyItem extends ReadonlyItem<Double> {
		public DoubleReadonlyItem(String id, String title) {
			super(id, title);
		}

		@Override
		protected String toString(Double value) {
			DoublePropertyEditor de = new DoublePropertyEditor(
					NumberFormat.getFormat("0.00"));
			if (value == null)
				value = 0.0;
			return de.render(value);
		}
	}

	@WidgetProvider()
	public DoubleReadonlyItem createAsReadonlyItem(String id, String title) {
		return new DoubleReadonlyItem(id, title);
	}
}
