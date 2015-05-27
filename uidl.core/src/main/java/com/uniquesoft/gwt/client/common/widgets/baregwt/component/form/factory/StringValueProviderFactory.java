package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

/**
 * This factory provides form item classes for String type.
 * There are four kinds of widgets now:TextBox,TextArea, PasswordBox and RichTextArea 
 *
 */
public class StringValueProviderFactory {
	@Inject
	private RuntimeGinjector runtimeGinjector;
	
	public static class TextItemBasedStringValueProvider implements
	IValueProvider<String> {

		private TextBox textItem;
		private GWTFormItem formItem;
		TextItemBasedStringValueProvider(String id,
				final String title){
			textItem = new TextBox();
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return textItem;
				}

			};
		}
		@Override
		public IValueProvider<String> setValue(String value) {
			textItem.setValue(value);
			return this;
		}

		@Override
		public GWTFormItem asWidget() {
		
			return formItem;
		}

		@Override
		public String getValue() {
			
			return textItem.getValue();
		}

		@Override
		public void addValueChangedListener(
				ValueChangedListener<String> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static class TextAreaBasedStringValueProvider implements
	IValueProvider<String> {

		private GWTFormItem formItem;
		private TextArea textAreaItem;
		TextAreaBasedStringValueProvider(String id,
				final String title){
			textAreaItem = new TextArea();
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return textAreaItem;
				}

			};
		}
		@Override
		public IValueProvider<String> setValue(String value) {
			textAreaItem.setValue(value);
			return this;
		}

		@Override
		public GWTFormItem asWidget() {
			
			return formItem;
		}

		@Override
		public String getValue() {
			
			return textAreaItem.getValue();
		}

		@Override
		public void addValueChangedListener(
				ValueChangedListener<String> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static class PasswordItemBasedStringValueProvider implements
						IValueProvider<String> {

		private GWTFormItem formItem;
		private PasswordTextBox pwItem;
		PasswordItemBasedStringValueProvider(String id,
				final String title){
			pwItem = new PasswordTextBox();
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return pwItem;
				}

			};
		}
		@Override
		public IValueProvider<String> setValue(String value) {
			
			pwItem.setValue(value);
			return this;
		}

		@Override
		public GWTFormItem asWidget() {
			
			return formItem;
		}

		@Override
		public String getValue() {
			
			return pwItem.getValue();
		}

		@Override
		public void addValueChangedListener(
				ValueChangedListener<String> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/**
	 * It is just a empty text area ,it needs to be add a tool bar
	 * to provider more functions.
	 *
	 */
	public static class RichTextEditorBasedStringValueProvider implements
	IValueProvider<String> {

		private GWTFormItem formItem;
		private RichTextArea richTextItem;
		RichTextEditorBasedStringValueProvider(String id,
				final String title){
			richTextItem = new RichTextArea();
			richTextItem.setSize("100%", "14em");
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return richTextItem;
				}

			};
		}
		@Override
		public IValueProvider<String> setValue(String value) {
			richTextItem.setText(value);
			return this;
		}

		@Override
		public GWTFormItem asWidget() {
		
			return formItem;
		}

		@Override
		public String getValue() {
			
			return richTextItem.getText();
		}

		@Override
		public void addValueChangedListener(
				ValueChangedListener<String> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@WidgetProvider(isDefault = true)
	public TextItemBasedStringValueProvider createAsTextItemAdaptor(String id,
			String title) {
		return new TextItemBasedStringValueProvider(id, title);
	}
	
	@WidgetProvider
	public TextAreaBasedStringValueProvider createAsTextAreaAdaptor(String id,
			String title) {
		return new TextAreaBasedStringValueProvider(id, title);
	}
	
	@WidgetProvider
	public PasswordItemBasedStringValueProvider createAsPasswordItemAdaptor(
			String id, String title) {
		return new PasswordItemBasedStringValueProvider(id, title);
	}
	
	@WidgetProvider
	public RichTextEditorBasedStringValueProvider createAsRichTextItemAdaptor(
			String id, String title) {
		return new RichTextEditorBasedStringValueProvider(id, title);
	}
}