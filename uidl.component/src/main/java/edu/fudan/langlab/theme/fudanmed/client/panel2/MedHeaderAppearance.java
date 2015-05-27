package edu.fudan.langlab.theme.fudanmed.client.panel2;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.theme.base.client.widget.HeaderDefaultAppearance;

public class MedHeaderAppearance extends HeaderDefaultAppearance {

  public interface MedHeaderStyle extends HeaderStyle {
    String header();

    String headerIcon();

    String headerHasIcon();

    String headerText();

    String headerBar();
  }

  public interface MedHeaderResources extends HeaderResources {

    @Source({ "edu/fudan/langlab/theme/fudanmed/client/widget/MedHeader.css","MedHeader.css"})
    MedHeaderStyle style();
    
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource headerBackground();
  }
  

  public MedHeaderAppearance() {
    this(GWT.<MedHeaderResources> create(MedHeaderResources.class),
        GWT.<Template> create(Template.class));
  }

  public MedHeaderAppearance(HeaderResources resources, Template template) {
    super(resources, template);
  }

}