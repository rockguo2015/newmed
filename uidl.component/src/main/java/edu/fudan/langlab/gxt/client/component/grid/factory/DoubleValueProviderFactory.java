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

public class DoubleValueProviderFactory implements IInitializerSupport {

	@Override
	public void initialize(IPostInitializeAction postInitialize) {
		postInitialize.initializeFinished(null);
	}

	public static class DoubleColumn<D> extends GXTGridColumn<D, Double> {

		public DoubleColumn(String id, String title,
				IObjectFieldAccessor<D, Double> objectValues) {
			columnConfig = new SummaryColumnConfig<D, Double>(
					new ValueProviderAdaptor<D, Double>(objectValues,id));
			columnConfig.setSummaryType(new SummaryType.SumSummaryType<Double>());
			
			columnConfig.setHeader(title);
			columnConfig.setCell(new NumberCell<Double>());
		}
		public DoubleColumn(String id, String title,
				IObjectFieldAccessor<D, Double> objectValues, Integer width) {
			columnConfig = new SummaryColumnConfig<D, Double>(
					new ValueProviderAdaptor<D, Double>(objectValues,id),width);
			columnConfig.setSummaryType(new SummaryType.SumSummaryType<Double>());
			columnConfig.setHeader(title);
			columnConfig.setCell(new NumberCell<Double>());
		}

		@Override
		public SummaryColumnConfig<D, Double> asWidget() {
			return columnConfig;
		}
	}

	public static class EditableDoubleColumn<D> extends DoubleColumn<D>
			implements IEditableColumn<D> {

		public EditableDoubleColumn(String id, String title,
				IObjectFieldAccessor<D, Double> objectValues) {
			super(id, title, objectValues);
		}

		@Override
		public void initializeEditor(GridEditing<D> gridEditing) {
			gridEditing.addEditor(this.asWidget(), new NumberField<Double>(
					new NumberPropertyEditor.DoublePropertyEditor()));

		}

	}

	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> DoubleColumn<D> createAsDoubleColumn(String id, String title,
			IObjectFieldAccessor<D, Double> objectValues) {
		return new DoubleColumn<D>(id, title, objectValues);
	}
	@WidgetProvider(isDefault = true)
	public <D> DoubleColumn<D> createAsDoubleColumn(String id, String title,
			IObjectFieldAccessor<D, Double> objectValues,Integer width) {
		return new DoubleColumn<D>(id, title,objectValues,width);
	}
	
	@WidgetProvider(requireAccessor = true)
	public <D> DoubleColumn<D> createAsEditableDoubleColumn(String id, String title,
			IObjectFieldAccessor<D, Double> objectValues) {
		return new EditableDoubleColumn<D>(id, title, objectValues);
	}	
}
