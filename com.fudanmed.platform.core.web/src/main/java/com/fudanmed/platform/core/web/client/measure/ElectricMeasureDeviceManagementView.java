package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateElectricMeasureDeviceCommand;
import com.fudanmed.platform.core.web.client.measure.DeleteElectricMeasureDeviceCommand;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceManagementPresenterView;
import com.fudanmed.platform.core.web.client.measure.UpdateElectricMeasureDeviceCommand;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
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

public class ElectricMeasureDeviceManagementView extends GWTAbstractView implements ElectricMeasureDeviceManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(createElectricMeasureDeviceCommand,updateElectricMeasureDeviceCommand,deleteElectricMeasureDeviceCommand),
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
  
  private ElectricMeasureDeviceListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final ElectricMeasureDeviceListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  private RCElectricMeasureDeviceTypeProxy context;
  
  @Inject
  private CreateElectricMeasureDeviceCommand createElectricMeasureDeviceCommand;
  
  @Inject
  private UpdateElectricMeasureDeviceCommand updateElectricMeasureDeviceCommand;
  
  @Inject
  private DeleteElectricMeasureDeviceCommand deleteElectricMeasureDeviceCommand;
  
  public void initialize() {
    
    ElectricMeasureDeviceListPresenterView _view = this.queryListPresenter.getView();
    ActionContext<UIElectricMeasureDevice> _actionContext = _view.getActionContext();
    final Function1<UIElectricMeasureDevice,RCElectricMeasureDeviceProxy> _function = new Function1<UIElectricMeasureDevice,RCElectricMeasureDeviceProxy>() {
        public RCElectricMeasureDeviceProxy apply(final UIElectricMeasureDevice it) {
          RCElectricMeasureDeviceProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<RCElectricMeasureDeviceProxy> ac = _actionContext.<RCElectricMeasureDeviceProxy>adapt(new Function<UIElectricMeasureDevice,RCElectricMeasureDeviceProxy>() {
        public RCElectricMeasureDeviceProxy apply(UIElectricMeasureDevice input) {
          return _function.apply(input);
        }
    });
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          ElectricMeasureDeviceListPresenterView _view = ElectricMeasureDeviceManagementView.this.queryListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          final Function0<RCElectricMeasureDeviceTypeProxy> _function = new Function0<RCElectricMeasureDeviceTypeProxy>() {
              public RCElectricMeasureDeviceTypeProxy apply() {
                return ElectricMeasureDeviceManagementView.this.context;
              }
            };
          it.<RCElectricMeasureDeviceTypeProxy>addCommand(_function, ElectricMeasureDeviceManagementView.this.createElectricMeasureDeviceCommand);
          it.addCommand(ac, ElectricMeasureDeviceManagementView.this.updateElectricMeasureDeviceCommand);
          it.addCommand(ac, ElectricMeasureDeviceManagementView.this.deleteElectricMeasureDeviceCommand);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
    this.con = _doubleArrow;
  }
  
  public void setContext(final RCElectricMeasureDeviceTypeProxy context) {
    this.context = context;
  }
}
