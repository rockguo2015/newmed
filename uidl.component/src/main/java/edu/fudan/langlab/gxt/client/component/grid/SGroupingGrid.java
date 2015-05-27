package edu.fudan.langlab.gxt.client.component.grid;

import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.GroupingView;

public class SGroupingGrid<M> extends SGrid<M> {

	public SGroupingGrid(ListStore<M> store, ColumnModel<M> cm) {
		super(store, cm);
	}
	
	public void groupBy(GXTGridColumn<M, ?> column, boolean showGroupedColumn){
		((GroupingView<M>)getView()).groupBy(column.columnConfig);
		((GroupingView<M>)getView()).setShowGroupedColumn(showGroupedColumn);
		column.columnConfig.setHidden(!showGroupedColumn);
	}

}
