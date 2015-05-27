package com.uniquesoft.gwt.client.common;

/**
 * 
 * A Handler that takes four argument.
 *
 * @param <T> the first argument that is passed to the {@link #execute(Object) closure}
 * @param <U> the second argument that is passed to the {@link #execute(Object) closure}
 * @param <V> the third argument that is passed to the {@link #execute(Object) closure}
 * @param <W> the forth argument that is passed to the {@link #execute(Object) closure}
 */
public interface RequestHandler4<T, U, V, W> {

	public void execute(T param1, U param2, V param3, W param4);

}
