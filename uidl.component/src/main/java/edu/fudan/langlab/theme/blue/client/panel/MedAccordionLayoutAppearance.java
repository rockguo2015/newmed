package edu.fudan.langlab.theme.blue.client.panel;

import com.google.gwt.core.client.GWT;
import com.sencha.gxt.theme.base.client.panel.AccordionLayoutBaseAppearance;
import com.sencha.gxt.theme.base.client.widget.HeaderDefaultAppearance;

public class MedAccordionLayoutAppearance extends AccordionLayoutBaseAppearance {
  
  public interface MedAccordionLayoutResources extends ContentPanelResources {

    @Source({"com/sencha/gxt/theme/base/client/panel/ContentPanel.css", "MedContentPanel.css"})
    @Override
    MedAccordionLayoutStyle style();

  }

  public interface MedAccordionLayoutStyle extends ContentPanelStyle {

  }
  
  public MedAccordionLayoutAppearance() {
    super(GWT.<MedAccordionLayoutResources> create(MedAccordionLayoutResources.class));
  }

  public MedAccordionLayoutAppearance(MedAccordionLayoutResources resources) {
    super(resources);
  }
  
  @Override
  public HeaderDefaultAppearance getHeaderAppearance() {
    return new MedAccordionHeaderAppearance();
  }
}
