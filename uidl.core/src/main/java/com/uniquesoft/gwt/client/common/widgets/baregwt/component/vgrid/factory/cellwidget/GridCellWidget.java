package com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory.cellwidget;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellWidget;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.ValueGetter;

/**
 * A subclass of {@link CellWidget} that implement the methods
 * for UIDL GWT-based V grid
 *
 * @param <D> the data type binding with the grid
 * @param <C> the data type binding with the cell
 */
public class GridCellWidget<D, C> extends CellWidget<C> {

	private D object;
	private FieldUpdater<D,C> fieldupdater;
	private ValueGetter<D,C> valuegetter;
	
	/**
	 * Construct the GridCellWidget this the given {@link Cell},
	 * {@link ValueGetter} and the {@code object}
	 * 
	 * @param cell {@link Cell}
	 * @param object the object that is binding with the column
	 * @param valuegetter {@link ValueGetter}
	 */
	public GridCellWidget(Cell<C> cell, D object, ValueGetter<D,C> valuegetter ) {
		super(cell, valuegetter.getValue(object));
		this.object = object;
		this.valuegetter = valuegetter;
		
	}

	/**
	 * Apply the fieldupdater after value is changed
	 */
	public void setValue(C value, boolean fireEvents, boolean redraw) {
		super.setValue(value, fireEvents, redraw);
		if(this.fieldupdater!=null){
			this.fieldupdater.update(0, this.object, value);
		}
	}
	
	/**
	 * Return the object that is binding to the column
	 */
	public D getObject() {
		return object;
	}

	/**
	 * Set the {@code object} and also set the value.
	 * 
	 * @param object the object this is binding to the column
	 */
	public void setObject(D object) {
		this.object = object;
		if(valuegetter!=null){
			setValue(this.valuegetter.getValue(object));
		}
	}
	/**
	 * Return the filed updater that is used to update the value
	 */
	public FieldUpdater<D,C> getFieldupdater() {
		return fieldupdater;
	}

	/**
	 * Set the {@code fieldupdater}
	 * 
	 * @param fieldupdater {@link FieldUpdater}
	 */
	public void setFieldupdater(FieldUpdater<D,C> fieldupdater) {
		this.fieldupdater = fieldupdater;
	}


	/**
	 * Return the {@link ValueGetter}
	 */
	public ValueGetter<D,C> getValuegetter() {
		return valuegetter;
	}

	/**
	 * Set the {@link ValueGetter} that is used to get the 
	 * value in the cell widget
	 */
	public void setValuegetter(ValueGetter<D,C> valuegetter) {
		this.valuegetter = valuegetter;
	}
}
