package com.uniquesoft.gwt.client.common.widgets.component;

/**
 * To configure a kind of component.
 * basePackage provides the path of the components items.
 * baseComponent is connected with a kind of base component, like form, listGrid, detailView and so on. 
 * When create a component, the component item will be matched by its type to find a model class to create in the provided basePackage.
 */
public @interface ComponentKit {
	String basePackage();
	String[] extensionPackages() default {};
	String baseComponent();
}
