package edu.fudan.langlab.gxt.client.component.grid;

import java.util.Map;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.SummaryColumnConfig;
import com.sencha.gxt.widget.core.client.grid.SummaryRenderer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

public class GXTGridColumn<D, C> implements IValueProvider<C> {

	protected SummaryColumnConfig<D, C> columnConfig;
	private boolean autoExpand = false;

	@Override
	public IValueViewer<C> setValue(C value) {
		return null;
	}

	@Override
	public SummaryColumnConfig<D, C> asWidget() {
		return columnConfig;
	}

	@Override
	public C getValue() {
		return null;
	}

	@Override
	public void addValueChangedListener(ValueChangedListener<C> listener) {
		// TODO Auto-generated method stub

	}

	ICellRender<C> cellRender;
	
	public void setGroupRender(final IGroupRender groupRender){
		columnConfig.setSummaryRenderer(new SummaryRenderer<D>() {

			@Override
			public SafeHtml render(Number value,
					Map<ValueProvider<? super D, ?>, Number> data) {
				SafeHtmlBuilder sb = new SafeHtmlBuilder();
				groupRender.render(value, sb);
				return sb.toSafeHtml();
			}
		});
	}

	public void setRender(final ICellRender<C> cellRender) {
		columnConfig.setCell(new AbstractCell<C>() {
			@Override
			public void render(com.google.gwt.cell.client.Cell.Context context,
					C value, SafeHtmlBuilder sb) {
				cellRender.render(context, value, sb);
			}
		});
	}

	public boolean isAutoExpand() {
		return autoExpand;
	}

	public void setAutoExpand(boolean autoExpand) {
//		throw new RuntimeException("???");
		this.autoExpand = autoExpand;
	}

}
