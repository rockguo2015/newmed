package com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.factory.rows;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.i18n.client.NumberFormat;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column.ValueGetter;
import com.uniquesoft.gwt.client.common.widgets.baregwt.component.vgrid.GWTGridRow;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;

/**
 * 
 * An implementation of Row that binding with the {@link NumberCell}.
 *
 * @param <D> the data type of cSolumn
 * @param <C> the data type of row
 */
public class GWTGridNumberRow<D,C extends Number> extends GWTGridRow<D, C, Number> {
	
	NumberFormat numberformat;
	
	/**
	 * Construct the Row with a given {@code title}, {@link IObjectFieldAccessor}
	 *  and {@link NumberFormat}.
	 *  
	 * @param id the id of the row
	 * @param title the head name of the row
	 * @param objectValues the {@link IObjectFieldAccessor}
	 * @param numberformat the {@link NumberFormat}
	 */
	public GWTGridNumberRow(String id, String title, final IObjectFieldAccessor<D, C> objectValues,NumberFormat numberformat) {
		super(title);
		this.numberformat = numberformat;
		ValueGetter<D,Number> valueGetter = new ValueGetter<D,Number>(){

			@Override
			public Number getValue(D object) {

				return objectValues.getValue(object);
			}
			
		};
		this.setValueGetter(valueGetter);
	}
	
	/**
	 * Construct the Row with a given {@code title}, {@link IObjectFieldAccessor}.
	 */
	public GWTGridNumberRow(String id, String title, final IObjectFieldAccessor<D, C> objectValues) {
		this(id,title,objectValues,NumberFormat.getPercentFormat());
	}
	
	/**
	 * Construct the Row with a given {@code title}, {@link IObjectFieldAccessor} 
	 * and the format template.
	 */
	public GWTGridNumberRow(String id, String title, final IObjectFieldAccessor<D, C> objectValues, String format) {
		this(id,title,objectValues,NumberFormat.getFormat(format));
	}

	@Override
	public Cell<Number> createCell() {
		return new NumberCell(this.numberformat);
	}

}
