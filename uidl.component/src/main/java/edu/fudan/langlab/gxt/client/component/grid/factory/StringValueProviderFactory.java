package edu.fudan.langlab.gxt.client.component.grid.factory;

import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.SummaryColumnConfig;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import edu.fudan.langlab.gxt.client.component.grid.ValueProviderAdaptor;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;

public class StringValueProviderFactory implements IInitializerSupport {

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	public static class StringColumn<D> extends GXTGridColumn<D, String> {

		public StringColumn(String id, String title,
				IObjectFieldAccessor<D, String> objectValues) {
			columnConfig = new SummaryColumnConfig<D, String>(
					new ValueProviderAdaptor<D, String>(objectValues,id));
			columnConfig.setHeader(title);
		}

		public StringColumn(String id, String title,
				IObjectFieldAccessor<D, String> objectValues, int width) {
			columnConfig = new SummaryColumnConfig<D, String>(
					new ValueProviderAdaptor<D, String>(objectValues,id), width,
					title);
		}

		@Override
		public SummaryColumnConfig<D, String> asWidget() {
			return columnConfig;
		}
	}

	public static class EditableStringColumn<D> extends StringColumn<D>
			implements IEditableColumn<D> {

		public EditableStringColumn(String id, String title,
				IObjectFieldAccessor<D, String> objectValues) {
			super(id, title, objectValues);
		}
		public EditableStringColumn(String id, String title,
				IObjectFieldAccessor<D, String> objectValues,int width) {
			super(id, title, objectValues,width);
		}

		@Override
		public void initializeEditor(GridEditing<D> gridEditing) {
			gridEditing.addEditor(this.asWidget(), new TextField());
		}
	}

	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> StringColumn<D> createAsStringColumn(String id, String title,
			IObjectFieldAccessor<D, String> objectValues) {
		return new StringColumn<D>(id, title, objectValues);
	}
	
	@WidgetProvider(requireAccessor = true)
	public <D> StringColumn<D> createAsEditableStringColumn(String id, String title,
			IObjectFieldAccessor<D, String> objectValues) {
		return new EditableStringColumn<D>(id, title, objectValues);
	}	
	@WidgetProvider(requireAccessor = true)
	public <D> StringColumn<D> createAsEditableStringColumn(String id, String title,
			IObjectFieldAccessor<D, String> objectValues,int width) {
		return new EditableStringColumn<D>(id, title, objectValues,width);
	}	

	@WidgetProvider(requireAccessor = true)
	public <D> StringColumn<D> createAsStringColumn(String id, String title,
			IObjectFieldAccessor<D, String> objectValues, int width) {
		return new StringColumn<D>(id, title, objectValues, width);
	}

	@WidgetProvider(requireAccessor = true)
	public <D> StringColumn<D> createAsAutoExpendStringColumn(String id,
			String title, IObjectFieldAccessor<D, String> objectValues) {
		StringColumn<D> result = new StringColumn<D>(id, title, objectValues);
		result.setAutoExpand(true);
		return result;
	}

}
