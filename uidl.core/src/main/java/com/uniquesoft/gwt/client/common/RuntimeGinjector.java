package com.uniquesoft.gwt.client.common;

import com.uniquesoft.gwt.client.common.name.IObjectNameProvider;


/**
 * An interface that can provider a name Provider for a specific project
 *
 */
public interface RuntimeGinjector {
	
	/**
	 * @return the nameProvider in specific project
	 */
	IObjectNameProvider getObjectNameProvider();
	
	
	
}
