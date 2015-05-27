package edu.fudan.langlab.gxt.client.component.propertyview.factory;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RuntimeGinjector;
import com.uniquesoft.gwt.client.common.async.IInitializerSupport;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.component.WidgetProvider;
import com.uniquesoft.gwt.client.common.widgets.valueprovider.IValueViewer;

public class DefaultObjectSelectorFactory implements IInitializerSupport {
	@Inject
	RuntimeGinjector runtimeGinjector;

	@Override
	public void initialize(IPostInitializeAction postInitialize) {

	}

	@WidgetProvider
	public <T> IValueViewer<T> createAsPropertyItem(String id, String title,
			int colSpan) {
		return new AbstractPropertyItem<T>(id, title, colSpan) {
			@Override
			public String toString(T value) {
				return runtimeGinjector.getObjectNameProvider().getName(value);
			}
		};
	}

	@WidgetProvider(isDefault=true)
	public <T> IValueViewer<T> createAsPropertyItem(String id, String title) {
		return new AbstractPropertyItem<T>(id, title) {
			@Override
			public String toString(T value) {
				return runtimeGinjector.getObjectNameProvider().getName(value);
			}
		};
	}

}
