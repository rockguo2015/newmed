package edu.fudan.langlab.theme.fudanmed.client.panel2;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.sencha.gxt.theme.base.client.frame.NestedDivFrame;
import com.sencha.gxt.theme.base.client.frame.NestedDivFrame.NestedDivFrameStyle;
import com.sencha.gxt.theme.base.client.panel.FramedPanelBaseAppearance;
import com.sencha.gxt.theme.base.client.widget.HeaderDefaultAppearance;

public class MedFramedPanelAppearance extends FramedPanelBaseAppearance {

  public interface FramedPanelStyle extends ContentPanelStyle {

  }

  public interface MedFramePanelResources extends ContentPanelResources {
    @Source({"com/sencha/gxt/theme/base/client/panel/ContentPanel.css", "MedFramedPanel.css"})
    @Override
    FramedPanelStyle style();
  }

  public interface MedFramePanelNestedDivFrameStyle extends NestedDivFrameStyle {

  }

  public interface MedFramedPanelDivFrameResources extends FramedPanelDivFrameResources, ClientBundle {

    @Source({"com/sencha/gxt/theme/base/client/frame/NestedDivFrame.css", "MedFramedPanelDivFrame.css"})
    @Override
    MedFramePanelNestedDivFrameStyle style();

    @ImageOptions(repeatStyle = RepeatStyle.Both)
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

    @ImageOptions(repeatStyle = RepeatStyle.Both)
    @Override
    ImageResource bottomLeftBorder();

    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    @Override
    ImageResource bottomBorder();

    @ImageOptions(repeatStyle = RepeatStyle.Both)
    @Override
    ImageResource bottomRightBorder();

  }

  public MedFramedPanelAppearance() {
    this(GWT.<MedFramePanelResources> create(MedFramePanelResources.class));
  }

  public MedFramedPanelAppearance(MedFramePanelResources resources) {
    super(resources, GWT.<FramedPanelTemplate> create(FramedPanelTemplate.class), new NestedDivFrame(
        GWT.<FramedPanelDivFrameResources> create(MedFramedPanelDivFrameResources.class)));
  }

  @Override
  public HeaderDefaultAppearance getHeaderAppearance() {
    return new MedHeaderFramedAppearance();
  }

}