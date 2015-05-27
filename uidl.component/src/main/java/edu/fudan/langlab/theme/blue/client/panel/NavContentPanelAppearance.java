package edu.fudan.langlab.theme.blue.client.panel;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.theme.base.client.panel.ContentPanelBaseAppearance;
import com.sencha.gxt.theme.base.client.widget.HeaderDefaultAppearance;

public class NavContentPanelAppearance extends ContentPanelBaseAppearance {

  public interface NavContentPanelResources extends ContentPanelResources {

    @Source({"com/sencha/gxt/theme/base/client/panel/ContentPanel.css", "MedContentPanel.css"})
    @Override
    NavContentPanelStyle style();

  }

  public interface NavContentPanelStyle extends ContentPanelStyle {

  }

  public NavContentPanelAppearance() {
    super(GWT.<NavContentPanelResources> create(NavContentPanelResources.class),
        GWT.<ContentPanelTemplate> create(ContentPanelTemplate.class));
  }

  public NavContentPanelAppearance(NavContentPanelResources resources) {
    super(resources, GWT.<ContentPanelTemplate> create(ContentPanelTemplate.class));
  }

  @Override
  public HeaderDefaultAppearance getHeaderAppearance() {
    return new NavHeaderAppearance();
  }

}

