package com.uniquesoft.gwt.client.common.widgets.contentprovider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for a class. it is mandatory for it to set some contents.
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface RequireContentProvider {

}
