package edu.fudan.langlab.theme.fudanmed.client.panel2;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.theme.base.client.widget.HeaderDefaultAppearance;

public class NavHeaderAppearance extends HeaderDefaultAppearance {

  public interface NavHeaderStyle extends HeaderStyle {
    String header();

    String headerIcon();

    String headerHasIcon();

    String headerText();

    String headerBar();
  }

  public interface NavHeaderResources extends HeaderResources {

    @Source({"com/sencha/gxt/theme/base/client/widget/Header.css", "NavHeader.css"})
    NavHeaderStyle style();
    
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource headerBackground();
  }
  

  public NavHeaderAppearance() {
    this(GWT.<NavHeaderResources> create(NavHeaderResources.class),
        GWT.<Template> create(Template.class));
  }

  public NavHeaderAppearance(HeaderResources resources, Template template) {
    super(resources, template);
  }

}