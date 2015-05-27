package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.Column;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.GWTGridColumn;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
/**
 * A basic implementation of UIDL GWT grid column that provide the general
 * method initColumn to initialize the UIDL grid Column.
 *
 * @param <D> the data type of row
 * @param <C> the data type of column
 * @param <V> the data type binding with cell
 */
public abstract class AbstractGWTGridColumn<D, C, V> extends GWTGridColumn<D, C> {

	/**
	 * Construct the Column this the {@code title}
	 * 
	 * @param title the head name of the column
	 */
	public AbstractGWTGridColumn(String title) {
		super(title);
	}
	
	/**
	 * Create the GWT Column with a given {@link Cell}.
	 * 
	 * Set the {@link ValueGetter} to implement the getvalue method,
	 * indicate how to get the value for column.
	 * 
	 * Set the {@link FieldUpdater} used for updating values in the column.
	 * 
	 * @param cell the {@link Cell} to display the column
	 * @param valueGeter the value getter
	 * @param fieldUpdater the field updater
	 */
	protected void initColumn(Cell<V> cell, final
			ValueGetter<D,V> valueGeter, FieldUpdater<D, V> fieldUpdater) {
		Column<D,V> gwtcolumn = new Column<D,V>(cell){

			@Override
			public V getValue(D object) {
				return valueGeter.getValue(object);
			}
			
		};
		if (fieldUpdater != null) {
			gwtcolumn.setFieldUpdater(fieldUpdater);
		}
		this.column = gwtcolumn;
	}
	
	/**
	 * Create the GWT Column with a given {@link Cell} and {@link ValueGetter}
	 * 
	 * @param cell the {@link Cell} to display the column.
	 * @param valueGeter the value getter
	 */
	protected void initColumn(Cell<V> cell, final
			ValueGetter<D,V> valueGeter){
		initColumn(cell, valueGeter, null );
	}
	
	/**
	 * Create new {@link FieldUpdater} and {@link ValueGetter}
	 * with a given {@link IObjectFieldAccessor}.
	 * Initialize GWT Column with the given {@link Cell} and the new.
	 * {@link FieldUpdater} and {@link ValueGetter}
	 * 
	 * @param cell cell the {@link Cell} to display the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	protected void initColumn(Cell<V> cell, final
			IObjectFieldAccessor<D,V> objectValues){
		
		ValueGetter<D,V> valueGeter = new ValueGetter<D,V> (){

			@Override
			public V getValue(D object) {
				return objectValues.getValue(object);
			}
			
		};
		FieldUpdater<D, V> fieldUpdater = new FieldUpdater<D, V>(){

			@Override
			public void update(int index, D object, V value) {
				objectValues.setValue(object, value);			
			}		
		};
		
		initColumn(cell, valueGeter, fieldUpdater );
	}
	
	
	/**
	 * Return the  {@link ValueGetter} that constructed with the {@code objectValues}
	 * 
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	protected ValueGetter<D,String> createStringGeter(final IObjectFieldAccessor<D,C> objectValues){
		ValueGetter<D,String> valueGeter = new ValueGetter<D,String> (){
			@Override
			public String getValue(D object) {
				return objectValues.getValue(object).toString();
			}
			
		};
		return valueGeter;
	}
}
