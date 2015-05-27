package com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Iterables;
import com.google.gwt.user.client.ui.Grid;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.widgets.ObjectListView;
import com.uniquesoft.gwt.client.common.widgets.component.Component;
import com.uniquesoft.gwt.client.common.widgets.component.ValueProviderComponent;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ICanAsWidget;

/**
 * 
 * A basic V grid component implementation that integrate the GWT {@link Grid}
 * widget.
 *
 * @param <T> the data type of column
 */
public abstract class GWTVGridComponent<T> extends ValueProviderComponent<T>
		implements ObjectListView<T> {
	private Grid grid = new Grid(0,1);
	private Iterable<T> objectlist;	
	private List<GWTGridRow<T, ?, ?>> rows = new ArrayList<GWTGridRow<T, ?, ?>>();
	private boolean initialized = false;
	
	/**
	 * Initialize the grid component, add the rows into the grid,
	 * mark the tag {@code initialized} to true
	 */
	protected void initialize() {
		this.grid.resizeRows(Iterables
				.size(getAllProperties()));
		int i=0;
		for (ICanAsWidget widget : getAllProperties()) {
			GWTGridRow<T, ?, ?> row = (GWTGridRow<T, ?, ?>) widget;
			rows.add(row);
			grid.setHTML(i++,0, "<b>"+row.getTitle()+"</b>");
		}
		initialized = true;
	}
	
	
	@Override
	public Iterable<T> getSelectedObjects() {
		throw new RuntimeException("unsupported operation");
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

	@Override
	public void setObjects(Iterable<T> result) {
		grid.clear();
		if(!initialized){
			this.initialize();
		}
		this.objectlist = result;		
		for(T object: this.objectlist){
			grid.resizeColumns(grid.getColumnCount()+1);
			int i = 0;
			for (GWTGridRow<T, ?, ?> row : this.rows) {
				grid.setWidget(i++,grid.getColumnCount()-1, row.createCellWidget(object));
			}
		}
		
	}

	@Override
	public Iterable<T> getObjects() {
		return objectlist;
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

	// public void setColumns(GWTGridColumn<T, ?>... columns) {
	// for (GWTGridColumn<T, ?> column : columns) {
	// dataGrid.addColumn( column.getColumn(), column.getTitle());
	// }
	// }

	/**
	 *  Return the GWT Widget {@code grid} that is initialized.
	 */
	public Grid asWidget() {
		if(!initialized){
			this.initialize();
		}
		return grid;
	}

}
