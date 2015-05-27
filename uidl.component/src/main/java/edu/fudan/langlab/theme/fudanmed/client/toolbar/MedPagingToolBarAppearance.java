package edu.fudan.langlab.theme.fudanmed.client.toolbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.sencha.gxt.theme.base.client.toolbar.PagingToolBarBaseAppearance;
import com.sencha.gxt.theme.blue.client.toolbar.BluePagingToolBarAppearance.BluePagingToolBarResources;

public class MedPagingToolBarAppearance  extends PagingToolBarBaseAppearance {
	 public interface MedPagingToolBarResources extends BluePagingToolBarResources {
		    ImageResource first();

		    ImageResource prev();

		    ImageResource next();

		    ImageResource last();

		    ImageResource refresh();

		    ImageResource loading();
		  }

		  public MedPagingToolBarAppearance() {
		    this(GWT.<MedPagingToolBarResources> create(MedPagingToolBarResources.class));
		  }

		  public MedPagingToolBarAppearance(MedPagingToolBarResources resources) {
		    super(resources);
		  }
}
