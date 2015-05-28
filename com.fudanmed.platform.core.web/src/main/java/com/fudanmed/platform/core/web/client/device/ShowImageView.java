package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.ShowImagePresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowImageView extends GWTAbstractView implements ShowImagePresenterView, IHasSize, IHasTitle {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    initialize();
    postInitialize.initializeFinished(null);
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  public Size getSize() {
    return new com.uniquesoft.gwt.client.common.widgets.Size(800,600);
  }
  
  public String getTitle() {
    return "图片浏览";
  }
  
  private Image img;
  
  public Widget asWidget() {
    return this.img;
  }
  
  public void initialize() {
    
    final Function1<Void,Image> _function = new Function1<Void,Image>() {
        public Image apply(final Void it) {
          Image _image = new Image();
          final Procedure1<Image> _function = new Procedure1<Image>() {
              public void apply(final Image it) {
              }
            };
          Image _doubleArrow = ObjectExtensions.<Image>operator_doubleArrow(_image, _function);
          return _doubleArrow;
        }
      };
    Image _lazy = ClientUi.<Image>lazy(this.img, _function);
    this.img = _lazy;
  }
  
  public void setUrl(final String imgUrl) {
    this.img.setUrl(imgUrl);
  }
}
