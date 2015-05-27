package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.datagrid;

import com.google.gwt.user.cellview.client.DataGrid;

public interface ListGridResource extends DataGrid.Resources {
	@Source({ "MyListGrid.css" })
	DataGrid.Style dataGridStyle();

}