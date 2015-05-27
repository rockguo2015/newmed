package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid;

import com.google.gwt.user.cellview.client.Column;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.ValueChangedManager.ValueChangedListener;

/**
 * 
 * A basic representation of a column in a UIDL grid.
 *
 * @param <D> the data type of the object that is binding with the grid
 * @param <C> the data type of the object that is binding with the column
 */
public class GWTGridColumn<D, C> implements IValueProvider<C>{
	protected Column<D, ?> column;
	private String title;

	/**
	 * Construct a new Column with a given title
	 * 
	 * @param title the name of Column's head
	 */
	public GWTGridColumn( String title) {
		super();
		this.title = title;
	}
	/**
	 * Get GWT {@link Column}
	 * 
	 * @return the {@code column}
	 */
	public Column<D, ?> getColumn() {
		return column;
	}

	/**
	 * Get the head name of the column
	 * 
	 * @return {@code title}
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the value {@code title}, it is the head name of the column
	 * 
	 * @param title the head name of the column
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public IValueViewer<C> setValue(C value) {
		return null;
	}

	@Override
	public Column<D, ?> asWidget() {
		return column;
	}

	@Override
	public C getValue() {
		return null;
	}

	@Override
	public void addValueChangedListener(ValueChangedListener<C> listener) {
		
	}

}
