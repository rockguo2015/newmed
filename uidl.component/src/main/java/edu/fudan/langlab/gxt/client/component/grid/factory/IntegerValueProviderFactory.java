package edu.fudan.langlab.gxt.client.component.grid.factory;

import com.sencha.gxt.cell.core.client.NumberCell;
import com.sencha.gxt.widget.core.client.form.NumberField;
import com.sencha.gxt.widget.core.client.form.NumberPropertyEditor;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.SummaryColumnConfig;
import com.sencha.gxt.widget.core.client.grid.SummaryType;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import edu.fudan.langlab.gxt.client.component.grid.ValueProviderAdaptor;

public class IntegerValueProviderFactory implements IInitializerSupport {

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		// TODO Auto-generated method stub
		
	}
	
	public static class IntegerColumn<D> extends GXTGridColumn<D, Integer> {

		public IntegerColumn(String id, String title,
				IObjectFieldAccessor<D, Integer> objectValues) {
			columnConfig = new SummaryColumnConfig<D, Integer>(
					new ValueProviderAdaptor<D, Integer>(objectValues,id));
			columnConfig.setSummaryType(new SummaryType.SumSummaryType<Integer>());
			
			columnConfig.setHeader(title);
			columnConfig.setCell(new NumberCell<Integer>());
		}
		public IntegerColumn(String id, String title,Integer width,
				IObjectFieldAccessor<D, Integer> objectValues) {
			columnConfig = new SummaryColumnConfig<D, Integer>(
					new ValueProviderAdaptor<D, Integer>(objectValues,id),width);
			columnConfig.setSummaryType(new SummaryType.SumSummaryType<Integer>());
			
			columnConfig.setHeader(title);
			columnConfig.setCell(new NumberCell<Integer>());
		}

		@Override
		public SummaryColumnConfig<D, Integer> asWidget() {
			return columnConfig;
		}
	}

	public static class EditableIntegerColumn<D> extends IntegerColumn<D>
			implements IEditableColumn<D> {

		public EditableIntegerColumn(String id, String title,
				IObjectFieldAccessor<D, Integer> objectValues) {
			super(id, title, objectValues);
		}

		@Override
		public void initializeEditor(GridEditing<D> gridEditing) {
			gridEditing.addEditor(this.asWidget(), new NumberField<Integer>(
					new NumberPropertyEditor.IntegerPropertyEditor()));

		}

	}
	
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> IntegerColumn<D> createAsIntegerColumn(String id, String title,
			IObjectFieldAccessor<D, Integer> objectValues) {
		return new IntegerColumn<D>(id, title, objectValues);
	}
	@WidgetProvider(isDefault = true)
	public <D> IntegerColumn<D> createAsIntegerColumn(String id, String title,
			IObjectFieldAccessor<D, Integer> objectValues, Integer width) {
		return new IntegerColumn<D>(id, title,width, objectValues);
	}
	
	@WidgetProvider(requireAccessor = true)
	public <D> IntegerColumn<D> createAsEditableIntegerColumn(String id, String title,
			IObjectFieldAccessor<D, Integer> objectValues) {
		return new EditableIntegerColumn<D>(id, title, objectValues);
	}	
}
