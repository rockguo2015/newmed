package com.uniquesoft.application;

import com.uniquesoft.gwt.client.common.widgets.IWidgetFactory;

/**
 * Indicate which class that implements the interface {@link IWidgetFactory} should be used
 *
 */
public @interface UseWidgetFactory {
	Class<? extends IWidgetFactory> value();
}
