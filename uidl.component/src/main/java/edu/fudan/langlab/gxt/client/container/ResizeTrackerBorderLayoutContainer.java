package edu.fudan.langlab.gxt.client.container;

import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;

public class ResizeTrackerBorderLayoutContainer extends BorderLayoutContainer {
	public ResizeTrackerBorderLayoutContainer() {
		setMonitorWindowResize(true);
	}

}
