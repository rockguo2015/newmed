package edu.fudan.langlab.theme.fudanmed.client.panel2;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

public class MedHeaderFramedAppearance extends MedHeaderAppearance {

  public interface MedHeaderFramedStyle extends HeaderStyle {

  }

  public interface MedFramedHeaderResources extends HeaderResources {

    @Source({"edu/fudan/langlab/theme/fudanmed/client/widget/MedHeader.css","MedHeader.css", "MedFramedHeader.css"})
    MedHeaderFramedStyle style();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource headerBackground();
  }

  public MedHeaderFramedAppearance() {
    this(GWT.<MedFramedHeaderResources> create(MedFramedHeaderResources.class), GWT.<Template> create(Template.class));
  }

  public MedHeaderFramedAppearance(MedFramedHeaderResources resources, Template template) {
    super(resources, template);
  }
}