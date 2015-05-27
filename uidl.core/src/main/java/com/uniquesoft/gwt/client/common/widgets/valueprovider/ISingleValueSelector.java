package com.uniquesoft.gwt.client.common.widgets.valueprovider;

/**
 * An interface for a single value widget that can get or set its value, or set its contents.
 * Like the radioButton, we can get a single value, but there are many choices for us to choose,
 * the the choices need to be set by the content provider
 *
 * @param <T>
 */
public interface ISingleValueSelector<T> extends ISelector<T>, IValueProvider<T> {
	
}
