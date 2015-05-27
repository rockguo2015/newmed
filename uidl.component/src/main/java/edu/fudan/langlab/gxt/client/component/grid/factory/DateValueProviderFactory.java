package edu.fudan.langlab.gxt.client.component.grid.factory;

import java.util.Date;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.SummaryColumnConfig;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import edu.fudan.langlab.gxt.client.component.grid.ValueProviderAdaptor;

public class DateValueProviderFactory implements IInitializerSupport {

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	public static class DateColumn<D> extends GXTGridColumn<D, Date> {

		public DateColumn(String id, String title,
				IObjectFieldAccessor<D, Date> objectValues) {
			columnConfig = new SummaryColumnConfig<D, Date>(
					new ValueProviderAdaptor<D, Date>(objectValues,id));
			columnConfig.setHeader(title);
			columnConfig.setCell(
					new DateCell(DateTimeFormat.getFormat("yyyy/MM/dd")){
						@Override
						public void render(
								com.google.gwt.cell.client.Cell.Context context,
								Date value, SafeHtmlBuilder sb) {
							super.render(context, value, sb);
						}
					});
		}

		public DateColumn(String id, String title,
				IObjectFieldAccessor<D, Date> objectValues, int width) {
			columnConfig = new SummaryColumnConfig<D, Date>(
					new ValueProviderAdaptor<D, Date>(objectValues,id),width);
			columnConfig.setHeader(title);
			columnConfig.setCell(
					new DateCell(DateTimeFormat.getFormat("yyyy/MM/dd")){
						@Override
						public void render(
								com.google.gwt.cell.client.Cell.Context context,
								Date value, SafeHtmlBuilder sb) {
							super.render(context, value, sb);
						}
					});
		}

		@Override
		public SummaryColumnConfig<D, Date> asWidget() {
			return columnConfig;
		}

	}
	
	public static class TimeColumn<D> extends GXTGridColumn<D, Date> {

		public TimeColumn(String id, String title,
				IObjectFieldAccessor<D, Date> objectValues) {
			columnConfig = new SummaryColumnConfig<D, Date>(
					new ValueProviderAdaptor<D, Date>(objectValues,id));
			columnConfig.setHeader(title);
			columnConfig.setCell(new DateCell(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.HOUR24_MINUTE)));
		}

		public TimeColumn(String id, String title,
				IObjectFieldAccessor<D, Date> objectValues, int width) {
			columnConfig = new SummaryColumnConfig<D, Date>(
					new ValueProviderAdaptor<D, Date>(objectValues,id),width);
			columnConfig.setHeader(title);
			columnConfig.setCell(new DateCell(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.HOUR24_MINUTE)));
		}

		@Override
		public SummaryColumnConfig<D, Date> asWidget() {
			return columnConfig;
		}

	}
	
	public static class DateTimeColumn<D> extends GXTGridColumn<D, Date> {

		public DateTimeColumn(String id, String title,
				IObjectFieldAccessor<D, Date> objectValues) {
			columnConfig = new SummaryColumnConfig<D, Date>(
					new ValueProviderAdaptor<D, Date>(objectValues,id),150);
			columnConfig.setHeader(title);
			columnConfig.setCell(new DateCell(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_TIME_SHORT)));
		}

		public DateTimeColumn(String id, String title,
				IObjectFieldAccessor<D, Date> objectValues, int width) {
			columnConfig = new SummaryColumnConfig<D, Date>(
					new ValueProviderAdaptor<D, Date>(objectValues,id),width);
			columnConfig.setHeader(title);
			columnConfig.setCell(new DateCell(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_TIME_SHORT)));
		}

		@Override
		public SummaryColumnConfig<D, Date> asWidget() {
			return columnConfig;
		}

	}	

	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> DateColumn<D> createAsStringColumn(String id, String title,
			IObjectFieldAccessor<D, Date> objectValues) {
		return new DateColumn<D>(id, title, objectValues);
	}

	@WidgetProvider(requireAccessor = true)
	public <D> DateColumn<D> createAsStringColumn(String id, String title,
			IObjectFieldAccessor<D, Date> objectValues, int width) {
		return new DateColumn<D>(id, title, objectValues, width);
	}

	@WidgetProvider(requireAccessor = true)
	public <D> TimeColumn<D> createAsTimeColumn(String id, String title,
			IObjectFieldAccessor<D, Date> objectValues) {
		return new TimeColumn<D>(id, title, objectValues);
	}
	
	@WidgetProvider(requireAccessor = true)
	public <D> TimeColumn<D> createAsTimeColumn(String id, String title,
			IObjectFieldAccessor<D, Date> objectValues, int width) {
		return new TimeColumn<D>(id, title, objectValues, width);
	}
	@WidgetProvider(requireAccessor = true)
	public <D> DateTimeColumn<D> createAsDateTimeColumn(String id, String title,
			IObjectFieldAccessor<D, Date> objectValues) {
		return new DateTimeColumn<D>(id, title, objectValues);
	}
	@WidgetProvider(requireAccessor = true)
	public <D> DateTimeColumn<D> createAsDateTimeColumn(String id, String title,
			IObjectFieldAccessor<D, Date> objectValues,int width) {
		return new DateTimeColumn<D>(id, title, objectValues,width);
	}
	
}
