package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid;

import com.google.common.collect.Lists;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.datagrid.AdvDataGrid;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.datagrid.DataGridResource;
import com.uniquesoft.gwt.client.common.widgets.component.Component;
import com.uniquesoft.gwt.client.common.widgets.component.ValueProviderComponent;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

/**
 * 
 * A basic grid component implementation that integrate the GWT {@link DataGrid}
 * widget.
 * 
 * @param <T>
 *            the data type of the row
 */
public abstract class GWTGridComponent<T> extends ValueProviderComponent<T>
		implements ObjectListView<T> {
	private DataGridResource resource = GWT.<DataGridResource> create(DataGridResource.class);
	private DataGrid<T> dataGrid = dataGrid = new AdvDataGrid<T>(60, resource, null);

	private MultiSelectionModel<T> selectionModel = new MultiSelectionModel<T>();

	private boolean initialized = false;

	/**
	 * Initialize the grid component, set the {@link MultiSelectionModel} and
	 * mark the tag {@code initialized} to true
	 */
	protected void initialize() {
		// DataGridResource reousrce = GWT.<DataGridResource>
		// create(DataGridResource.class);
		// dataGrid = new AdvDataGrid<T> (60, reousrce,null);
//		dataGrid = new AdvDataGrid<T>(60, resource, null);
		dataGrid.setSelectionModel(this.selectionModel);
		this.initialized = true;
	}

	/*public void setResource(DataGridResource resource) {

		this.resource = resource;
	}*/

	@Override
	public Iterable<T> getSelectedObjects() {
		return selectionModel.getSelectedSet();
	}
	@Override
	public void deselect() {
		throw new RuntimeException("unsupported operation");
		
	}
	@Override
	public void addSelectionChangedListener(
			com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener<T> listener) {
		// TODO Auto-generated method stub

	}
	
	private ListDataProvider<T> listDataPrivider = new ListDataProvider<T>();

	@Override
	public void setObjects(Iterable<T> result) {
		getListDataPrivider().setList(Lists.newArrayList(result));
		getListDataPrivider().addDataDisplay(dataGrid);
	}

	@Override
	public Iterable<T> getObjects() {
		return getListDataPrivider().getList();
	}

	@Override
	public void addContentChangedListener(
			com.uniquesoft.gwt.client.common.widgets.ObjectListView.ContentChangedListener<T> listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSelectEntityListener(
			com.uniquesoft.gwt.client.common.widgets.ObjectListView.SelectEntityListener<T> listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setComponentProvider(
			Provider<? extends Component<T>> componentProvider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addElement(T uientity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeElement(T uientity) {
		// TODO Auto-generated method stub

	}

	/**
	 * Add each column into the {@code dataGrid}
	 * 
	 * @param columns
	 *            the column items for the grid
	 */
	public void setColumns(GWTGridColumn<T, ?>... columns) {
		/*if (!initialized) {
			this.initialize();
		}*/
		for (GWTGridColumn<T, ?> column : columns) {
			dataGrid.addColumn(column.getColumn(), column.getTitle());
		}

	}

	/**
	 * Return the GWT widget {@code dataGrid} of type {@link DataGrid}
	 */
	public DataGrid<T> asWidget() {
		if (!initialized) {
			this.initialize();
		}
		return dataGrid;
	}

	/**
	 * Return the GWT widget {@code dataGrid} of type {@link DataGrid} that has
	 * all the column items in.
	 */
	public DataGrid<T> asWidgetWithColumns() {
		/*if (!initialized) {
			this.initialize();
		}*/
		for (ICanAsWidget widget : getAllProperties()) {
			GWTGridColumn<?, ?> column = (GWTGridColumn<?, ?>) widget;
			dataGrid.addColumn((Column<T, ?>) (column.getColumn()),
					column.getTitle());
		}
		return dataGrid;
	}

	/**
	 * 
	 * Return the {@code listDataPrivider} of type {@link ListDataProvider}, the
	 * listDataPrivider support the grid deal with the data.
	 */
	public ListDataProvider<T> getListDataPrivider() {
		return listDataPrivider;
	}

	/**
	 * Set the {@code listDataPrivider} to provide the support for handling
	 * data.
	 * 
	 * @param listDataPrivider
	 *            the {@link ListDataProvider}
	 */
	public void setListDataPrivider(ListDataProvider<T> listDataPrivider) {
		this.listDataPrivider = listDataPrivider;
	}
}
