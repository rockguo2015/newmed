package edu.fudan.langlab.gxt.client.component.propertyview.factory;

import com.google.gwt.i18n.client.NumberFormat;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;

public class DoubleValueProviderFactory implements IInitializerSupport {

	public final class PrecentPropertyItem extends
			AbstractPropertyItem<Double> {
		public PrecentPropertyItem(String id, String name, int colspan) {
			super(id,name,colspan);
		}
		public PrecentPropertyItem(String id, String name) {
			super(id,name);
		}

		@Override
		public String toString(Double value) {
			if(value==null) return "";
			return NumberFormat.getFormat("###").format(Math.round(value*100))+"%";
		}
	}
	public final class DoublePropertyItem extends AbstractPropertyItem<Double> {
		public DoublePropertyItem(String id, String name, int colspan) {
			super(id,name,colspan);
		}
		public DoublePropertyItem(String id, String name) {
			super(id,name);
		}
		@Override
		public String toString(Double value) {
			if(value==null) return "";
			else return NumberFormat.getFormat("#,###.00").format(value);
		}
	}
	
	public final class MoneyPropertyItem extends AbstractPropertyItem<Double> {
		public MoneyPropertyItem(String id, String name, int colspan) {
			super(id,name,colspan);
		}
		public MoneyPropertyItem(String id, String name) {
			super(id,name);
		}
		@Override
		public String toString(Double value) {
			if(value==null || value == 0) return "--";
			else return NumberFormat.getFormat("#,###.00").format(value);
		}
	}
	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	@WidgetProvider(isDefault = true)
	public DoublePropertyItem createAsDoubleItem(String id, String title) {
		return new DoublePropertyItem(id,title);
	}
	@WidgetProvider
	public PrecentPropertyItem createAsPrecentItem(String id, String title) {
		return new PrecentPropertyItem(id,title);
	}
	@WidgetProvider
	public MoneyPropertyItem createAsMoneyItem(String id, String title) {
		return new MoneyPropertyItem(id,title);
	}

}
