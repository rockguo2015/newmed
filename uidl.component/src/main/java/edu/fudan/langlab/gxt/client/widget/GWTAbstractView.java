package edu.fudan.langlab.gxt.client.widget;

import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.uniquesoft.gwt.client.common.Viewer;

/**
 * A basic Viewer implementation for GWT, this class integrate the widget
 * {@link VerticalPanel}.
 */
public abstract class GWTAbstractView implements Viewer {
	
	
	public GWTAbstractView() {
	}

	@Override
	public abstract Widget asWidget();

	
	@Override
	public void destroy() {
		//do nothing by default
	}


}
