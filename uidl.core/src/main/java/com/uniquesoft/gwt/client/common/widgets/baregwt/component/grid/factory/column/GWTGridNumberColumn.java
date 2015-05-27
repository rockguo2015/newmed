package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.i18n.client.NumberFormat;
import com.uniquesoft.gwt.shared.common.IObjectFieldAccessor;
/**
 * AnS implementation of Number Column that binding with the {@link NumberCell}.
 *
 * @param <D> type of Row
 * @param <C> type of Column
 */
public class GWTGridNumberColumn<D,C extends Number> extends AbstractGWTGridColumn<D, C, Number> {
	
	/**
	 * Construct the Column with a given {@code title}, {@link IObjectFieldAccessor}
	 *  and {@link NumberFormat}.
	 * 
	 * @param id the id of the column
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 * @param numberformat the {@link NumberFormat}
	 */
	public GWTGridNumberColumn(String id, String title, final IObjectFieldAccessor<D, C> objectValues,NumberFormat numberformat) {
		super(title);
		ValueGetter<D,Number> valueGetter = new ValueGetter<D,Number>(){

			@Override
			public Number getValue(D object) {

				return objectValues.getValue(object);
			}
			
		};
		initColumn(new NumberCell(numberformat), valueGetter);
	}
	
	/**
	 * Construct the Column with given {@code title}, {@link IObjectFieldAccessor}.
	 *  
	 * @param id the id of the column
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 */
	public GWTGridNumberColumn(String id, String title, final IObjectFieldAccessor<D, C> objectValues) {
		this(id,title,objectValues,NumberFormat.getPercentFormat());
	}
	
	/**
	 * Construct the Column with given {@code title}, {@link IObjectFieldAccessor}
	 *  and {@code NumberFormat}. The {@link NumberFormat} is generated from the 
	 *  template {@code format}.
	 * 
	 * @param id the id of the column
	 * @param title the head name of the column
	 * @param objectValues the {@link IObjectFieldAccessor}
	 * @param format the format template
	 */
	public GWTGridNumberColumn(String id, String title, final IObjectFieldAccessor<D, C> objectValues, String format) {
		this(id,title,objectValues,NumberFormat.getFormat(format));
	}

}
