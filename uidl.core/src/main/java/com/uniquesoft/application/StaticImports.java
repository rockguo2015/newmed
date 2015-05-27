package com.uniquesoft.application;

/**
 * Indicate the the packages of the Classes that shall be static import
 */
public @interface StaticImports {
	Class<?>[] value();
}
