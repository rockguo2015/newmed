package com.uniquesoft.gwt.client.common;

/**
 * A Handler that takes one argument.
 * 
 * @param <T>
 *            the only argument that is passed to the {@link #execute(Object) closure}
 */

public interface RequestHandler1<T> {

	public void execute(T param);

}
