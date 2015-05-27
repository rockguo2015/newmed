package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.datagrid;

import com.google.gwt.user.cellview.client.DataGrid;

public interface DataGridResource extends DataGrid.Resources {
	@Source({ "MyDataGrid.css" })
	DataGrid.Style dataGridStyle();

}