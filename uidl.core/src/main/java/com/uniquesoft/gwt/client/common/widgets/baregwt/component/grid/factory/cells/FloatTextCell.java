package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.cells;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

/**
 * A simple implementation of Textcell base on the data type Float
 *
 */
public class FloatTextCell extends AbstractCell<Float> {

	/**
	 * Set the float value into the html element
	 */
	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context,
			Float value, SafeHtmlBuilder sb) {
		sb.append(value);
		
	}
	
}
