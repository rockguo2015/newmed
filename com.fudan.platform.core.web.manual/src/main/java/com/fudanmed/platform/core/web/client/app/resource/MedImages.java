package com.fudanmed.platform.core.web.client.app.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface MedImages extends ClientBundle{
	public MedImages INSTANCE = GWT.create(MedImages.class);

	  @Source("nav0.png")
	  ImageResource nav0();
	  
	  @Source("nav1.png")
	  ImageResource nav1();
	  
	  @Source("nav2.png")
	  ImageResource nav2();
	  
	  @Source("nav3.png")
	  ImageResource nav3();
	  
	  @Source("nav4.png")
	  ImageResource nav4();
	  
	  @Source("nav5.png")
	  ImageResource nav5();

	  @Source("nav_bt.jpg")
	  ImageResource nav_bt();
	  
	  @Source("nav_bts.png")
	  ImageResource nav_bts();
	  
	  @Source("download.gif")
	  ImageResource download();
	  
	  @Source("viewimage.gif")
	  ImageResource viewimage();
	  


}
