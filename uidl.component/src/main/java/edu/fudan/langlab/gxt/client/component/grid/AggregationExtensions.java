package edu.fudan.langlab.gxt.client.component.grid;

import com.google.common.base.Objects;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.sencha.gxt.widget.core.client.grid.AggregationRenderer;
import com.sencha.gxt.widget.core.client.grid.AggregationRowConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.SummaryColumnConfig;
import edu.fudan.langlab.gxt.client.component.grid.ColumnRenderPair;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridColumn;
import edu.fudan.langlab.gxt.client.component.grid.GXTGridComponent;
import edu.fudan.langlab.gxt.client.component.grid.IHasState;
import edu.fudan.langlab.gxt.client.component.grid.SGroupingGrid;
import edu.fudan.langlab.gxt.client.component.treegrid.GXTTreeGridComponent;
import edu.fudan.langlab.gxt.client.component.treegrid.SGrid;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class AggregationExtensions {
  public static <T extends Object, S extends Object> AggregationRowConfig<T> createSummaryRow(final GXTGridComponent<T> grid) {
    AggregationRowConfig<T> _xblockexpression = null;
    {
      AggregationRowConfig<T> _aggregationRowConfig = new AggregationRowConfig<T>();
      AggregationRowConfig<T> result = _aggregationRowConfig;
      SGroupingGrid<T> _asWidget = grid.asWidget();
      ColumnModel<T> _columnModel = _asWidget.getColumnModel();
      _columnModel.addAggregationRow(result);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public static <T extends Object, S extends Object> AggregationRowConfig<T> createSummaryRow(final GXTTreeGridComponent<T> grid) {
    AggregationRowConfig<T> _xblockexpression = null;
    {
      AggregationRowConfig<T> _aggregationRowConfig = new AggregationRowConfig<T>();
      AggregationRowConfig<T> result = _aggregationRowConfig;
      SGrid<T> _asWidget = grid.asWidget();
      ColumnModel<T> _columnModel = _asWidget.getColumnModel();
      _columnModel.addAggregationRow(result);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  public static <T extends Object> void operator_add(final AggregationRowConfig<T> rowConfig, final ColumnRenderPair<T> columnRender) {
    SummaryColumnConfig<T,? extends Object> _asWidget = columnRender.column.asWidget();
    final Function2<Integer,Grid<T>,SafeHtml> _function = new Function2<Integer,Grid<T>,SafeHtml>() {
        public SafeHtml apply(final Integer colIndex, final Grid<T> grid) {
          SafeHtml _xblockexpression = null;
          {
            SummaryColumnConfig<T,? extends Object> _asWidget = columnRender.column.asWidget();
            HorizontalAlignmentConstant _alignment = _asWidget.getAlignment();
            boolean _equals = Objects.equal(_alignment, HasHorizontalAlignment.ALIGN_RIGHT);
            if (_equals) {
              SummaryColumnConfig<T,? extends Object> _asWidget_1 = columnRender.column.asWidget();
              rowConfig.setCellStyle(_asWidget_1, "grid_aggr_right");
            }
            SummaryColumnConfig<T,? extends Object> _asWidget_2 = columnRender.column.asWidget();
            _asWidget_2.getAlignment();
            SafeHtmlBuilder _safeHtmlBuilder = new SafeHtmlBuilder();
            SafeHtmlBuilder builder = _safeHtmlBuilder;
            Object state = ((IHasState) grid).getState();
            columnRender.render.apply(builder, state);
            SafeHtml _safeHtml = builder.toSafeHtml();
            _xblockexpression = (_safeHtml);
          }
          return _xblockexpression;
        }
      };
    rowConfig.setRenderer(_asWidget, new AggregationRenderer<T>() {
        public SafeHtml render(int colIndex,Grid<T> grid) {
          return _function.apply(colIndex,grid);
        }
    });
  }
  
  public static <T extends Object> ColumnRenderPair<T> renderSummaryColumn(final GXTGridColumn<T,? extends Object> column, final Procedure2<? super SafeHtmlBuilder,? super Object> render) {
    ColumnRenderPair<T> _columnRenderPair = new ColumnRenderPair<T>(column, render);
    return _columnRenderPair;
  }
}
