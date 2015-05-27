package edu.fudan.langlab.gxt.client.component.grid.factory;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.sencha.gxt.cell.core.client.SimpleSafeHtmlCell;
import com.sencha.gxt.widget.core.client.form.CheckBox;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.SummaryColumnConfig;
import com.sencha.gxt.widget.core.client.grid.editing.GridEditing;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import edu.fudan.langlab.gxt.client.component.grid.ValueProviderAdaptor;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.EditableIntegerColumn;
import edu.fudan.langlab.gxt.client.component.grid.factory.IntegerValueProviderFactory.IntegerColumn;

public class BooleanValueProviderFactory {

	public static class BooleanColumn<D> extends GXTGridColumn<D, Boolean> {

		public BooleanColumn(String id, String title,
				IObjectFieldAccessor<D, Boolean> objectValues) {
			columnConfig = new SummaryColumnConfig<D, Boolean>(
					new ValueProviderAdaptor<D, Boolean>(objectValues,id));
			columnConfig.setHeader(title);
			columnConfig.setCell(new SimpleSafeHtmlCell<Boolean>(
					new AbstractSafeHtmlRenderer<Boolean>() {

						@Override
						public SafeHtml render(Boolean object) {
							return SafeHtmlUtils.fromString(object ? "是" : "否");
						}
					}));
		}

		@Override
		public SummaryColumnConfig<D, Boolean> asWidget() {
			return columnConfig;
		}
	}

	public static class EditableBooleanColumn<D> extends BooleanColumn<D>
			implements IEditableColumn<D> {

		public EditableBooleanColumn(String id, String title,
				IObjectFieldAccessor<D, Boolean> objectValues) {
			super(id, title, objectValues);
		}

		@Override
		public void initializeEditor(GridEditing<D> gridEditing) {
			gridEditing.addEditor(this.asWidget(), new CheckBox());

		}
	}
	
	@WidgetProvider(isDefault = true, requireAccessor = true)
	public <D> BooleanColumn<D> createAsBooleanColumn(String id, String title,
			IObjectFieldAccessor<D, Boolean> objectValues) {
		return new BooleanColumn<D>(id, title, objectValues);
	}
	
	@WidgetProvider(requireAccessor = true)
	public <D> BooleanColumn<D> createAsEditableBooleanColumn(String id, String title,
			IObjectFieldAccessor<D, Boolean> objectValues) {
		return new EditableBooleanColumn<D>(id, title, objectValues);
	}		
}
