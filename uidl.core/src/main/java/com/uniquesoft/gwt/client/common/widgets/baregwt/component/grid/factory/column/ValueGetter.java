package com.uniquesoft.gwt.client.common.widgets.baregwt.component.grid.factory.column;

/**
 * A ValueGetter provides a method to get the value
 *
 * @param <D> the data type that value if from
 * @param <V> the data type of the value
 */
public interface ValueGetter<D,V> {
	V getValue(D object);
}
