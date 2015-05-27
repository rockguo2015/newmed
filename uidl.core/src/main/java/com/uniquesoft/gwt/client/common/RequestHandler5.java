package com.uniquesoft.gwt.client.common;
/**
 * 
 * A Handler that takes five argument.
 *
 * @param <T> the first argument that is passed to the {@link #execute(Object) closure}
 * @param <U> the second argument that is passed to the {@link #execute(Object) closure}
 * @param <V> the third argument that is passed to the {@link #execute(Object) closure}
 * @param <W> the forth argument that is passed to the {@link #execute(Object) closure}
 * @param <X> the fifth argument that is passed to the {@link #execute(Object) closure}
 */
public interface RequestHandler5<T, U, V, W, X> {

	public void execute(T param1, U param2, V param3, W param4, X param5);

}
