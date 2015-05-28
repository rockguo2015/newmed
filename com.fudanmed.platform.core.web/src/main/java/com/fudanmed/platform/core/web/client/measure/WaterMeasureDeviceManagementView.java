package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateWaterMeasureDeviceCommand;
import com.fudanmed.platform.core.web.client.measure.DeleteWaterMeasureDeviceCommand;
import com.fudanmed.platform.core.web.client.measure.UpdateWaterMeasureDeviceCommand;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceManagementPresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.ContentPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WaterMeasureDeviceManagementView extends GWTAbstractView implements WaterMeasureDeviceManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(createWaterMeasureDeviceCommand,updateWaterMeasureDeviceCommand,deleteWaterMeasureDeviceCommand),
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
  
  private WaterMeasureDeviceListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final WaterMeasureDeviceListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  private RCWaterMeasureDeviceTypeProxy context;
  
  @Inject
  private CreateWaterMeasureDeviceCommand createWaterMeasureDeviceCommand;
  
  @Inject
  private UpdateWaterMeasureDeviceCommand updateWaterMeasureDeviceCommand;
  
  @Inject
  private DeleteWaterMeasureDeviceCommand deleteWaterMeasureDeviceCommand;
  
  public void initialize() {
    
    WaterMeasureDeviceListPresenterView _view = this.queryListPresenter.getView();
    ActionContext<UIWaterMeasureDevice> _actionContext = _view.getActionContext();
    final Function1<UIWaterMeasureDevice,RCWaterMeasureDeviceProxy> _function = new Function1<UIWaterMeasureDevice,RCWaterMeasureDeviceProxy>() {
        public RCWaterMeasureDeviceProxy apply(final UIWaterMeasureDevice it) {
          RCWaterMeasureDeviceProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<RCWaterMeasureDeviceProxy> ac = _actionContext.<RCWaterMeasureDeviceProxy>adapt(new Function<UIWaterMeasureDevice,RCWaterMeasureDeviceProxy>() {
        public RCWaterMeasureDeviceProxy apply(UIWaterMeasureDevice input) {
          return _function.apply(input);
        }
    });
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          WaterMeasureDeviceListPresenterView _view = WaterMeasureDeviceManagementView.this.queryListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          final Function0<RCWaterMeasureDeviceTypeProxy> _function = new Function0<RCWaterMeasureDeviceTypeProxy>() {
              public RCWaterMeasureDeviceTypeProxy apply() {
                return WaterMeasureDeviceManagementView.this.context;
              }
            };
          it.<RCWaterMeasureDeviceTypeProxy>addCommand(_function, WaterMeasureDeviceManagementView.this.createWaterMeasureDeviceCommand);
          it.addCommand(ac, WaterMeasureDeviceManagementView.this.updateWaterMeasureDeviceCommand);
          it.addCommand(ac, WaterMeasureDeviceManagementView.this.deleteWaterMeasureDeviceCommand);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
    this.con = _doubleArrow;
  }
  
  public void setContext(final RCWaterMeasureDeviceTypeProxy context) {
    this.context = context;
  }
}
