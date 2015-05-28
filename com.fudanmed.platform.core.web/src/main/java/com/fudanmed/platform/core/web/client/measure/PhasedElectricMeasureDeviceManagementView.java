package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreatePhasedElectricMeasureDeviceCommand;
import com.fudanmed.platform.core.web.client.measure.DeletePhasedElectricMeasureDeviceCommand;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceManagementPresenterView;
import com.fudanmed.platform.core.web.client.measure.UpdatePhasedElectricMeasureDeviceCommand;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
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

public class PhasedElectricMeasureDeviceManagementView extends GWTAbstractView implements PhasedElectricMeasureDeviceManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(createPhasedElectricMeasureDeviceCommand,updatePhasedElectricMeasureDeviceCommand,deletePhasedElectricMeasureDeviceCommand),
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
  
  private PhasedElectricMeasureDeviceListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final PhasedElectricMeasureDeviceListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  private RCPhasedElectricMeasureDeviceTypeProxy context;
  
  @Inject
  private CreatePhasedElectricMeasureDeviceCommand createPhasedElectricMeasureDeviceCommand;
  
  @Inject
  private UpdatePhasedElectricMeasureDeviceCommand updatePhasedElectricMeasureDeviceCommand;
  
  @Inject
  private DeletePhasedElectricMeasureDeviceCommand deletePhasedElectricMeasureDeviceCommand;
  
  public void initialize() {
    
    PhasedElectricMeasureDeviceListPresenterView _view = this.queryListPresenter.getView();
    ActionContext<UIPhasedElectricMeasureDevice> _actionContext = _view.getActionContext();
    final Function1<UIPhasedElectricMeasureDevice,RCPhasedElectricMeasureDeviceProxy> _function = new Function1<UIPhasedElectricMeasureDevice,RCPhasedElectricMeasureDeviceProxy>() {
        public RCPhasedElectricMeasureDeviceProxy apply(final UIPhasedElectricMeasureDevice it) {
          RCPhasedElectricMeasureDeviceProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<RCPhasedElectricMeasureDeviceProxy> ac = _actionContext.<RCPhasedElectricMeasureDeviceProxy>adapt(new Function<UIPhasedElectricMeasureDevice,RCPhasedElectricMeasureDeviceProxy>() {
        public RCPhasedElectricMeasureDeviceProxy apply(UIPhasedElectricMeasureDevice input) {
          return _function.apply(input);
        }
    });
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          PhasedElectricMeasureDeviceListPresenterView _view = PhasedElectricMeasureDeviceManagementView.this.queryListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          final Function0<RCPhasedElectricMeasureDeviceTypeProxy> _function = new Function0<RCPhasedElectricMeasureDeviceTypeProxy>() {
              public RCPhasedElectricMeasureDeviceTypeProxy apply() {
                return PhasedElectricMeasureDeviceManagementView.this.context;
              }
            };
          it.<RCPhasedElectricMeasureDeviceTypeProxy>addCommand(_function, PhasedElectricMeasureDeviceManagementView.this.createPhasedElectricMeasureDeviceCommand);
          it.addCommand(ac, PhasedElectricMeasureDeviceManagementView.this.updatePhasedElectricMeasureDeviceCommand);
          it.addCommand(ac, PhasedElectricMeasureDeviceManagementView.this.deletePhasedElectricMeasureDeviceCommand);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
    this.con = _doubleArrow;
  }
  
  public void setContext(final RCPhasedElectricMeasureDeviceTypeProxy context) {
    this.context = context;
  }
}
