package edu.fudan.langlab.uidl.domain.app.client;

import com.google.gwt.resources.client.ImageResource;

public interface WorkbenchPartCategory {
	String getCategoryId();

	String getCategoryName();
	
	ImageResource getImage();
	
	Boolean isVisable();
}
