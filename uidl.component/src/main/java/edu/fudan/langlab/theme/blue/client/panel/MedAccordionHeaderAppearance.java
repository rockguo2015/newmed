package edu.fudan.langlab.theme.blue.client.panel;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.theme.base.client.widget.HeaderDefaultAppearance;

public class MedAccordionHeaderAppearance extends HeaderDefaultAppearance {

  public interface MedAccordionHeaderStyle extends HeaderStyle {
    String header();

    String headerIcon();

    String headerHasIcon();

    String headerText();

    String headerBar();
  }

  public interface MedAccordionHeaderResources extends HeaderResources {

    @Source({"com/sencha/gxt/theme/base/client/widget/Header.css", "MedHeader.css", "MedAccordionHeader.css"})
    MedAccordionHeaderStyle style();

    @Source("light-hd.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource headerBackground();
  }

  public MedAccordionHeaderAppearance() {
    super(GWT.<MedAccordionHeaderResources> create(MedAccordionHeaderResources.class));
  }

}
