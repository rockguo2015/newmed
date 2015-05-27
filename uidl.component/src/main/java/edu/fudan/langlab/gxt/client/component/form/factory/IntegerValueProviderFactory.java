package edu.fudan.langlab.gxt.client.component.form.factory;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.NumberInputCell;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.IntegerPropertyEditor;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

import edu.fudan.langlab.gxt.client.widget.ScoreField.ScoreField;

public class IntegerValueProviderFactory {

	public static class IntegerItem implements IValueProvider<Integer> {

		private NumberField<Integer> doubleField;
		private FieldLabel fieldLabel;

		public IntegerItem(String id, String title, Boolean isRequired) {
			IntegerPropertyEditor de = new IntegerPropertyEditor();
			if (isRequired) {
				fieldLabel = new FieldLabel(
						doubleField = new NumberField<Integer>(
								new NumberInputCell<Integer>(de), de));
				fieldLabel.setHTML(Forms.toRequiredTitle(title));
			} else {
				fieldLabel = new FieldLabel(
						doubleField = new NumberField<Integer>(
								new NumberInputCell<Integer>(de), de), title);
			}
		}

		@Override
		public IValueViewer<Integer> setValue(Integer value) {
			doubleField.setValue(value);
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public Integer getValue() {
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
				final ValueChangedListener<Integer> listener) {
			doubleField
					.addValueChangeHandler(new ValueChangeHandler<Integer>() {

						@Override
						public void onValueChange(
								ValueChangeEvent<Integer> event) {
							listener.onValueChanged(event.getValue());

						}
					});

		}
	}

	@WidgetProvider(isDefault = true)
	public IntegerItem createAsIntegerItem(String id, String title) {
		return new IntegerItem(id, title, false);
	}

	@WidgetProvider
	public IntegerItem createAsRequiredIntegerItem(String id, String title) {
		return new IntegerItem(id, title, true);
	}

	public static class IntegerReadonlyItem extends ReadonlyItem<Integer> {
		public IntegerReadonlyItem(String id, String title) {
			super(id, title);
		}

		@Override
		protected String toString(Integer value) {
			if (value == null)
				return "";
			IntegerPropertyEditor de = new IntegerPropertyEditor();
			return de.render(value);
		}
	}

	@WidgetProvider()
	public IntegerReadonlyItem createAsReadonlyItem(String id, String title) {
		return new IntegerReadonlyItem(id, title);
	}

	public static class ScoreItem implements IValueProvider<Integer> {

		private ScoreField acoreField;
		private FieldLabel fieldLabel;

		public ScoreItem(String id, String title, int max, Boolean isRequired) {
			if (isRequired) {
				fieldLabel = new FieldLabel(acoreField = new ScoreField(max));
				fieldLabel.setHTML(Forms.toRequiredTitle(title));
			} else {
				fieldLabel = new FieldLabel(acoreField = new ScoreField(max),
						title);
			}
		}

		@Override
		public IValueViewer<Integer> setValue(Integer value) {
			acoreField.setValue(value);
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public Integer getValue() {
			return acoreField.getValue();
		}

		@Override
		public void addValueChangedListener(
				final ValueChangedListener<Integer> listener) {
			acoreField.addValueChangeHandler(new ValueChangeHandler<Integer>() {

				@Override
				public void onValueChange(ValueChangeEvent<Integer> event) {
					listener.onValueChanged(event.getValue());

				}
			});

		}
	}

	@WidgetProvider
	public ScoreItem createAsScoreItem(String id, String title, int max) {
		return new ScoreItem(id, title, max, false);
	}

}
