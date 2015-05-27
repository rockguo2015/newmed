package com.uniquesoft.gwt.client.common;

/**
 * 
* A Handler that takes two argument.
 *
 * @param <T> the first argument that is passed to the {@link #execute(Object) closure}
 * @param <U> the second argument that is passed to the {@link #execute(Object) closure}
 */
public interface RequestHandler2<T, U> {

	public void execute(T param1, U param2);

}
