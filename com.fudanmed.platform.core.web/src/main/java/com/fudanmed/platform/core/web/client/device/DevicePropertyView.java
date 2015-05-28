package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DeviceProperty;
import com.fudanmed.platform.core.web.client.device.DevicePropertyPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

public class DevicePropertyView extends GWTAbstractView implements DevicePropertyPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(propertyView),
    	new com.uniquesoft.gwt.client.common.async.IPostInitializeAction(){
    
    	public void initializeFinished(Void v) {
    		initialize();
    		postInitialize.initializeFinished(null);
    	}
    });
    
  }
  
  @Inject
  private Securities securities;
  
  @Inject
  private EventBus eventBus;
  
  private Widget con;
  
  @Inject
  private DeviceProperty propertyView;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    final Function1<Void,VerticalLayoutContainer> _function = new Function1<Void,VerticalLayoutContainer>() {
        public VerticalLayoutContainer apply(final Void it) {
          VerticalLayoutContainer _asWidget = DevicePropertyView.this.propertyView.asWidget();
          return _asWidget;
        }
      };
    Widget _lazy = ClientUi.<Widget>lazy(this.con, _function);
    this.con = _lazy;
  }
  
  public void setValue(final UIDevice device) {
    
    this.propertyView.setValue(device);
  }
}
