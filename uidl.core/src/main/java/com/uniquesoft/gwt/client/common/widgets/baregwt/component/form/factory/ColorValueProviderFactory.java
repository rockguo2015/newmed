package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.datatype.Color;

/**
 * This factory is for Color type.
 *
 */
public class ColorValueProviderFactory {
	/**
	 * Use a TextBox to show the Color value.
	 *
	 */
	public static class StringColorValueSelector  implements IValueProvider<Color>{

		private TextBox colorItem;
		private GWTFormItem formItem;
		StringColorValueSelector(String id, final String title){
			colorItem = new TextBox();
			formItem = new GWTFormItem() {
				Label label = new Label(title);

				@Override
				public Widget getLabelWidget() {
					return label;
				}

				@Override
				public Widget getValueWidget() {
					return colorItem;
				}

			};
		}
		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer#setValue(java.lang.Object)
		 * Set the TextBox's value about the Color.
		 */
		@Override
		public IValueProvider<Color> setValue(Color value) {
			
			if(value!=null)
				colorItem.setValue(value.getColorCode());
			return this;
		}

		@Override
		public GWTFormItem asWidget() {
		
			return formItem;
		}

		/* (non-Javadoc)
		 * @see com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider#getValue()
		 * Create a Color and set the textbox's value in it.
		 */
		@Override
		public Color getValue() {
			if(colorItem.getValue()!=null){
				Color c = new Color();
				c.setColorCode(colorItem.getValue());
				return c;
			}else 
				return null;
		}

		@Override
		public void addValueChangedListener(ValueChangedListener<Color> listener) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@WidgetProvider(isDefault=true)
	public StringColorValueSelector createAsTextItem(String id, String title){
		return new StringColorValueSelector(id,title);
	}
}