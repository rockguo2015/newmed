package com.uniquesoft.gwt.client.common;

import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;

/**
 * A basic Viewer implementation for GWT, this class integrate the widget
 * {@link VerticalPanel}.
 */
public abstract class GWTAbstractView extends FlowPanel implements Viewer {
	/**
	 * Create an empty vertical panel, and set the width and height to 100%
	 * 
	 */
	public GWTAbstractView() {
		setWidth("100%");
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	public <T extends Object> AsyncCallback<T> onSuccess(
			final Procedure1<? super T> onSuccess) {
		final ConfigurableAsyncCallback<T> callback = new ConfigurableAsyncCallback<T>();
		callback.onSuccessDo(onSuccess);
		return callback;
	}	
	/**
	 * Add a child widget to the viewer
	 * 
	 * @param widget
	 *            the widget to be added
	 */
	public void addWidget(Widget widget) {
		add(widget);
	}

}
