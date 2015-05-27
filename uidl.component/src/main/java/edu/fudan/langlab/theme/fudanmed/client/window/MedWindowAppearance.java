package edu.fudan.langlab.theme.fudanmed.client.window;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.theme.base.client.frame.NestedDivFrame;
import com.sencha.gxt.theme.base.client.frame.NestedDivFrame.NestedDivFrameStyle;
import com.sencha.gxt.theme.base.client.panel.FramedPanelBaseAppearance;
import com.sencha.gxt.theme.base.client.widget.HeaderDefaultAppearance;
import com.sencha.gxt.theme.base.client.widget.HeaderDefaultAppearance.HeaderResources;
import com.sencha.gxt.theme.base.client.widget.HeaderDefaultAppearance.HeaderStyle;
import com.sencha.gxt.widget.core.client.Window.WindowAppearance;

import edu.fudan.langlab.theme.fudanmed.client.panel2.MedFramedPanelAppearance.FramedPanelStyle;

public class MedWindowAppearance extends FramedPanelBaseAppearance implements WindowAppearance {

  public interface MedWindowDivFrameStyle extends NestedDivFrameStyle {

  }

  public interface MedWindowDivFrameResources extends FramedPanelDivFrameResources, ClientBundle {

    @Source({"com/sencha/gxt/theme/base/client/frame/NestedDivFrame.css", "MedWindowDivFrame.css"})
    @Override
    MedWindowDivFrameStyle style();

    @Source("com/sencha/gxt/theme/base/client/shared/clear.gif")
    ImageResource background();

    @Override
    ImageResource topLeftBorder();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Override
    ImageResource topBorder();

    @Override
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource topRightBorder();

    @ImageOptions(repeatStyle = RepeatStyle.Vertical)
    @Override
    ImageResource leftBorder();

    @ImageOptions(repeatStyle = RepeatStyle.Both)
    @Override
    ImageResource rightBorder();

    @Override
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource bottomLeftBorder();

    @ImageOptions(repeatStyle = RepeatStyle.Both)
    @Override
    ImageResource bottomBorder();

    @Override
    @ImageOptions(repeatStyle = RepeatStyle.Both)
    ImageResource bottomRightBorder();

  }

  public interface MedWindowStyle extends FramedPanelStyle {
    String ghost();
  }

  public interface MedHeaderStyle extends HeaderStyle {

  }

  public interface MedHeaderResources extends HeaderResources {
    @Source({ "edu/fudan/langlab/theme/fudanmed/client/widget/MedHeader.css", "MedWindowHeader.css"})
    MedHeaderStyle style();
  }

  public interface MedWindowResources extends ContentPanelResources, ClientBundle {

    @Source({
        "com/sencha/gxt/theme/base/client/panel/ContentPanel.css",
        "com/sencha/gxt/theme/base/client/window/Window.css", "MedWindow.css"})
    @Override
    MedWindowStyle style();

  }

  private MedWindowStyle style;

  public MedWindowAppearance() {
    this((MedWindowResources) GWT.create(MedWindowResources.class));
  }

  public MedWindowAppearance(MedWindowResources resources) {
    super(resources, GWT.<FramedPanelTemplate> create(FramedPanelTemplate.class), new NestedDivFrame(
        GWT.<MedWindowDivFrameResources> create(MedWindowDivFrameResources.class)));

    this.style = resources.style();
  }

  @Override
  public HeaderDefaultAppearance getHeaderAppearance() {
    return new HeaderDefaultAppearance(GWT.<MedHeaderResources> create(MedHeaderResources.class));
  }

  @Override
  public String ghostClass() {
    return style.ghost();
  }
}