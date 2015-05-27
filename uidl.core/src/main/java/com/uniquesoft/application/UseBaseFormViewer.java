package com.uniquesoft.application;

import com.uniquesoft.gwt.client.common.Viewer;

/**
 * Indicate which class should be the base class of View
 *
 */
public @interface UseBaseFormViewer {
	Class<? extends Viewer> value();
}
