package com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.factory;

import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.detail.factory.item.SingleElementDetailItem;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

/**
 * When we want to show the detail for a String type, this class provided
 * the detail items for the String type to choose.
 */
public class StringValueProviderFactory {
	

	public static class StringDetaiItem extends SingleElementDetailItem<String> {

		private Label content = new Label();

		public StringDetaiItem(String id, String title) {
			super(id, title);
			
			add(titleLabel);
			add(contentContainer);
			
			contentContainer.add(content);
		}

		@Override
		public IValueViewer<String> setValue(String value) {
			content.setText(value==null?"":value);
			return this;
		}
	}
	@WidgetProvider(isDefault = true)
	public StringDetaiItem createAsDetailItem(String id, String title) {
		return new StringDetaiItem(id, title);
	}

	public static class MailDetailItem extends SingleElementDetailItem<String> {

		private Hyperlink content = new Hyperlink();
		public MailDetailItem(String id, String title) {
			super(id, title);
			add(titleLabel);
			add(contentContainer);
			contentContainer.add(content);
		}

		@Override
		public IValueViewer<String> setValue(String value) {
			String mailAddr = value==null?"":value;
			content.setHTML("<a href=mailto:" + mailAddr + ">" + mailAddr
					+ "</a>");
			return this;
		}
	}
	@WidgetProvider
	public MailDetailItem createAsMailItem(String id, String title) {
		return new MailDetailItem(id, title);
	}

}
