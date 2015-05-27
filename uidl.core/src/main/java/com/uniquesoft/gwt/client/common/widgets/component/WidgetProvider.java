package com.uniquesoft.gwt.client.common.widgets.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Annotation configuration for component item. 
 * isDefault means the item class will be created if you do not establish it.
 * isReadonly means the widget can not be edited  
 * requireAccessor means it needs to provide the getValue() and setValue() methods.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@Inherited
public @interface WidgetProvider {
	
	boolean isDefault() default false;

	boolean isReadonly() default false;
	
	boolean requireAccessor() default false;
	
}
