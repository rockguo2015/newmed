package com.uniquesoft.gwt.client.common.widgets.baregwt.component.form;

import com.uniquesoft.gwt.client.common.widgets.component.ComponentKit;

/**
 * When matching the form item , language will look for the 
 * possible matchable class factory in the  basePackage;
 * and the form container is the baseComponent.In this
 * mechanism, we directly use asWidget() method in each
 * form item to set each item widget on the page. 
 *
 */
@ComponentKit(basePackage="com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.factory",
baseComponent="com.uniquesoft.gwt.client.common.widgets.baregwt.component.form.GWTFormComponent")
public @interface GWTFormConfig {

}
