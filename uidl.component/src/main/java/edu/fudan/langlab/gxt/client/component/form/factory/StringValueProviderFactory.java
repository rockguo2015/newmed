package edu.fudan.langlab.gxt.client.component.form.factory;

import com.google.common.base.Strings;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.HtmlEditor;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class StringValueProviderFactory implements IInitializerSupport {

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	public static class EscapedTextItem extends TextItem {

		public EscapedTextItem(String id, String title) {
			super(id, title, false);
		}

		@Override
		public String getValue() {
			if (Strings.isNullOrEmpty(super.getValue())) {
				return null;
			} else {
				return "%" + super.getValue() + "%";
			}
		}
	}

	public static class MyTextField extends TextField {
		public MyTextField() {
			InputElement el = this.getInputEl().cast();
			el.setMaxLength(255);
		}
	}

	public static class RichTextItem implements IValueProvider<String> {
		private HtmlEditor editor;
		private FieldLabel fieldLabel;

		public RichTextItem(String id, String title, Boolean isRequired) {
			if (isRequired) {
				fieldLabel = new FieldLabel(editor = new HtmlEditor());
				fieldLabel.setHTML(Forms.toRequiredTitle(title));
			} else
				fieldLabel = new FieldLabel(editor = new HtmlEditor(), title);
		}

		@Override
		public IValueViewer<String> setValue(String value) {
			editor.setValue(value);
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public String getValue() {
			return editor.getValue();
		}
		
		public void focus(){
			editor.focus();
		}
		public Component getField(){
			return editor;
		}
		
		@Override
		public void addValueChangedListener(
				ValueChangedListener<String> listener) {
		}

	}

	public static class TextItem implements IValueProvider<String> {

		private TextField textField;
		private FieldLabel fieldLabel;

		public TextItem(String id, String title, Boolean isRequired) {
			if (isRequired) {
				fieldLabel = new FieldLabel(textField = new MyTextField());
				fieldLabel.setHTML(Forms.toRequiredTitle(title));
			} else
				fieldLabel = new FieldLabel(textField = new MyTextField(),
						title);
		}

		@Override
		public IValueViewer<String> setValue(String value) {
			textField.setValue(value);
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public String getValue() {
			return textField.getValue();
		}

		public void focus() {
			textField.focus();
		}
		public Component getField(){
			return textField;
		}

		@Override
		public void addValueChangedListener(
				final ValueChangedListener<String> listener) {
			textField.addValueChangeHandler(new ValueChangeHandler<String>() {

				@Override
				public void onValueChange(ValueChangeEvent<String> event) {
					listener.onValueChanged(event.getValue());

				}
			});
		}
	}

	public static class PasswordItem implements IValueProvider<String> {
		private PasswordField textField;
		private FieldLabel fieldLabel;

		public PasswordItem(String id, String title) {
			fieldLabel = new FieldLabel(textField = new PasswordField(), title);
		}

		@Override
		public IValueViewer<String> setValue(String value) {
			textField.setValue(value);
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public String getValue() {
			return textField.getValue();
		}

		public void focus() {
			textField.focus();
		}
		public Component getField(){
			return textField;
		}

		@Override
		public void addValueChangedListener(
				final ValueChangedListener<String> listener) {
			textField.addValueChangeHandler(new ValueChangeHandler<String>() {

				@Override
				public void onValueChange(ValueChangeEvent<String> event) {
					listener.onValueChanged(event.getValue());

				}
			});
		}
	}

	public static class TextAreaItem implements IValueProvider<String> {

		private TextArea textField;
		private FieldLabel fieldLabel;

		public TextAreaItem(String id, String title, Boolean isRequired) {
			if (isRequired) {
				fieldLabel = new FieldLabel(textField = new TextArea());
				fieldLabel.setHTML(Forms.toRequiredTitle(title));
			} else
				fieldLabel = new FieldLabel(textField = new TextArea(), title);
		}

		@Override
		public IValueViewer<String> setValue(String value) {
			textField.setValue(value);
			return this;
		}

		@Override
		public FieldLabel asWidget() {
			return fieldLabel;
		}

		@Override
		public String getValue() {
			return textField.getValue();
		}

		public void focus() {
			textField.focus();
		}
		public Component getField(){
			return textField;
		}

		@Override
		public void addValueChangedListener(
				final ValueChangedListener<String> listener) {
			textField.addValueChangeHandler(new ValueChangeHandler<String>() {

				@Override
				public void onValueChange(ValueChangeEvent<String> event) {
					listener.onValueChanged(event.getValue());

				}
			});
		}
	}

	@WidgetProvider(isDefault = true)
	public TextItem createAsTextItem(String id, String title) {
		return new TextItem(id, title, false);
	}

	@WidgetProvider
	public TextItem createAsRequiredTextItem(String id, String title) {
		return new TextItem(id, title, true);
	}

	@WidgetProvider()
	public TextItem createAsEscapedTextItem(String id, String title) {
		return new EscapedTextItem(id, title);
	}

	@WidgetProvider()
	public TextAreaItem createAsTextAreaItem(String id, String title) {
		return new TextAreaItem(id, title, false);
	}

	@WidgetProvider()
	public RichTextItem createAsRichTextItem(String id, String title) {
		return new RichTextItem(id, title, false);
	}

	@WidgetProvider()
	public TextAreaItem createAsRequiredTextAreaItem(String id, String title) {
		return new TextAreaItem(id, title, true);
	}

	@WidgetProvider()
	public PasswordItem createAsPasswordItem(String id, String title) {
		return new PasswordItem(id, title);
	}

	public static class StringReadonlyItem extends ReadonlyItem<String> {
		public StringReadonlyItem(String id, String title) {
			super(id, title);
		}

		@Override
		protected String toString(String value) {
			if (value == null)
				return "";
			else
				return value;
		}
	}

	public StringReadonlyItem createAsReadonlyItem(String id, String title) {
		return new StringReadonlyItem(id, title);
	}

}
