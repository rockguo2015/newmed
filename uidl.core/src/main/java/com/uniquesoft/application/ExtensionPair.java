package com.uniquesoft.application;

public @interface ExtensionPair {
	
	Class<?> target();

	Class<?>[] extensions();

}
