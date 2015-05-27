package edu.fudan.langlab.gxt.client.component.grid

import com.google.gwt.safehtml.shared.SafeHtmlBuilder
import com.sencha.gxt.widget.core.client.grid.AggregationRowConfig
import edu.fudan.langlab.gxt.client.component.treegrid.GXTTreeGridComponent
import com.google.gwt.user.client.ui.HasHorizontalAlignment

class ColumnRenderPair<T>{
	
	public GXTGridColumn<T,?> column
	public (SafeHtmlBuilder,Object)=>void render
	
	new(GXTGridColumn<T,?> column,(SafeHtmlBuilder,Object)=>void render){
		this.column = column
		this.render = render
	}
}

class AggregationExtensions {
	def static <T,S> AggregationRowConfig<T> createSummaryRow(GXTGridComponent<T> grid){
		var result = new AggregationRowConfig<T>()
		grid.asWidget.getColumnModel.addAggregationRow(result)
		result
	} 
	
	def static <T,S> AggregationRowConfig<T> createSummaryRow(GXTTreeGridComponent<T> grid){
		var result = new AggregationRowConfig<T>()
		grid.asWidget.getColumnModel.addAggregationRow(result)
		result
	} 
	
	def static <T> void operator_add(AggregationRowConfig<T> rowConfig,ColumnRenderPair<T>  columnRender){
		rowConfig.setRenderer(columnRender.column.asWidget)[colIndex,grid|
			if(columnRender.column.asWidget.alignment == HasHorizontalAlignment::ALIGN_RIGHT){
				rowConfig.setCellStyle(columnRender.column.asWidget,"grid_aggr_right")
				}
			columnRender.column.asWidget.alignment
			var builder = new SafeHtmlBuilder()
			var state = (grid as IHasState).state
			columnRender.render.apply(builder,state)
			builder.toSafeHtml
		]
	}
	
	def static <T> ColumnRenderPair<T> renderSummaryColumn(GXTGridColumn<T,?> column,(SafeHtmlBuilder,Object)=>void render){
		new ColumnRenderPair(column,render)
	}
}