package edu.fudan.langlab.gxt.client.component.propertyview.factory;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;

public class DateValueProviderFactory  implements IInitializerSupport {

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}
	public class DatePropertyItem extends AbstractPropertyItem<Date> {
		public DatePropertyItem() {
			super();
		}

		public DatePropertyItem(String id, String name, int colspan) {
			super(id, name, colspan);
		}

		public DatePropertyItem(String id, String name) {
			super(id, name);
		}

		@Override
		public String toString(Date value) {
			if(value==null) return "";
			return DateTimeFormat.getFormat("yyyy-MM-dd").format(value);
		}
	}

	public class TimePropertyItem extends AbstractPropertyItem<Date> {
		public TimePropertyItem() {
			super();
		}

		public TimePropertyItem(String id, String name, int colspan) {
			super(id, name, colspan);
		}

		public TimePropertyItem(String id, String name) {
			super(id, name);
		}

		@Override
		public String toString(Date value) {
			if(value==null) return "";
			return DateTimeFormat.getFormat(PredefinedFormat.HOUR24_MINUTE)
					.format(value);
		}
	}
	public class DateTimePropertyItem extends AbstractPropertyItem<Date> {
		public DateTimePropertyItem() {
			super();
		}
		
		public DateTimePropertyItem(String id, String name, int colspan) {
			super(id, name, colspan);
		}
		
		public DateTimePropertyItem(String id, String name) {
			super(id, name);
		}
		
		@Override
		public String toString(Date value) {
			if(value==null) return "";
			return DateTimeFormat.getFormat(PredefinedFormat.DATE_TIME_SHORT)
					.format(value);
		}
	}

	@WidgetProvider(isDefault = true)
	public DatePropertyItem createAsDateItem(String id, String title) {
		return new DatePropertyItem(id, title);
	}

	@WidgetProvider
	public DatePropertyItem createAsDateItem(String id, String title,
			int colspan) {
		return new DatePropertyItem(id, title, colspan);
	}
	@WidgetProvider(isDefault = true)
	public TimePropertyItem createAsTimeItem(String id, String title) {
		return new TimePropertyItem(id, title);
	}
	
	@WidgetProvider
	public TimePropertyItem createAsTimeItem(String id, String title,
			int colspan) {
		return new TimePropertyItem(id, title, colspan);
	}
	@WidgetProvider
	public DateTimePropertyItem createAsDateTimeItem(String id, String title) {
		return new DateTimePropertyItem(id, title);
	}
	@WidgetProvider
	public DateTimePropertyItem createAsDateTimeItem(String id, String title,
			int colspan) {
		return new DateTimePropertyItem(id, title, colspan);
	}

}
