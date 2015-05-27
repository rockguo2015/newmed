package com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellWidget;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.ValueGetter;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory.cellwidget.GridCellWidget;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * A representation of a row in a table.
 *
 * @param <D> the Column type
 * @param <C> the row type
 * @param <V> the type binding with Cell
 */
public abstract class GWTGridRow<D, C, V> implements IValueProvider<C>{
	private String title;
	
    private ValueGetter<D,V> valueGetter;
    private FieldUpdater<D,V> fileldUpdater;
	
	/**
	 * Construct a new Row with a given title
	 * 
	 * @param title the head name fo the row
	 */
	public GWTGridRow( String title) {
		super();
		this.title = title;
	}

	/**
	 * Return a new {@link CellWidget} that is structured with the 
	 * given object.
	 * 
	 * @param object the object that is binding with the column
	 */
	public CellWidget<V> createCellWidget(D object){
		GridCellWidget<D, V> cellwidget = new GridCellWidget<D, V>(
				createCell(), object, this.getValueGetter());
		cellwidget.setFieldupdater(this.getFileldUpdater());
		return cellwidget;
	}
	
	/**
	 * Return a new Cell, this method shall be called to provide a
	 * Cell for {@link #createCellWidget()} 
	 * 
	 */
	public abstract Cell<V> createCell() ;

	/**
	 * Return the head name of the Row
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the {@code title}
	 * 
	 * @param title the head name of the Row
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public IValueViewer<C> setValue(C value) {
		return null;
	}


	@Override
	public C getValue() {
		return null;
	}

	@Override
	public void addValueChangedListener(ValueChangedListener<C> listener) {
		
	}

	/**
	 * Return the {@code valueGetter} of type {@link ValueGetter}
	 */
	public ValueGetter<D,V> getValueGetter() {
		return valueGetter;
	}

	/**
	 * Set the {@code valueGetter} that is used to get value in the Row.
	 * 
	 * @param valueGetter the value getter
	 */
	public void setValueGetter(ValueGetter<D,V> valueGetter) {
		this.valueGetter = valueGetter;
	}
	
	@Override
	public Object asWidget() {
		return null;
	}

	/**
	 * Return filed updater
	 */
	public FieldUpdater<D,V> getFileldUpdater() {
		return fileldUpdater;
	}

	/**
	 * Set the filed updater that is used to update value in the 
	 * row.
	 * 
	 * @param fileldUpdater the filed updater
	 */
	public void setFileldUpdater(FieldUpdater<D,V> fileldUpdater) {
		this.fileldUpdater = fileldUpdater;
	}
	
	/**
	 * Initialize the Row with the given {@link IObjectFieldAccessor}
	 * 
	 * @param filedAccessor the {@link IObjectFieldAccessor}
	 */
	protected void initRow(final
			IObjectFieldAccessor<D,V> filedAccessor){
		this.fileldUpdater = new FieldUpdater<D, V>() {

			@Override
			public void update(int index, D object, V value) {
				if(object!=null){
					filedAccessor.setValue(object, value);
				}
				
			}
		};
		
		this.valueGetter = new ValueGetter<D, V>() {

			@Override
			public V getValue(D object) {
				if(object==null)
					return null;
				return filedAccessor.getValue(object);
			}
		};
	}

}
