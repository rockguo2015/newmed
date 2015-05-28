package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateGasMeasureDeviceCommand;
import com.fudanmed.platform.core.web.client.measure.DeleteGasMeasureDeviceCommand;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceListPresenter;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceListPresenterView;
import com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceManagementPresenterView;
import com.fudanmed.platform.core.web.client.measure.UpdateGasMeasureDeviceCommand;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
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

public class GasMeasureDeviceManagementView extends GWTAbstractView implements GasMeasureDeviceManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(createGasMeasureDeviceCommand,updateGasMeasureDeviceCommand,deleteGasMeasureDeviceCommand),
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
  
  private GasMeasureDeviceListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final GasMeasureDeviceListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  private RCGasMeasureDeviceTypeProxy context;
  
  @Inject
  private CreateGasMeasureDeviceCommand createGasMeasureDeviceCommand;
  
  @Inject
  private UpdateGasMeasureDeviceCommand updateGasMeasureDeviceCommand;
  
  @Inject
  private DeleteGasMeasureDeviceCommand deleteGasMeasureDeviceCommand;
  
  public void initialize() {
    
    GasMeasureDeviceListPresenterView _view = this.queryListPresenter.getView();
    ActionContext<UIGasMeasureDevice> _actionContext = _view.getActionContext();
    final Function1<UIGasMeasureDevice,RCGasMeasureDeviceProxy> _function = new Function1<UIGasMeasureDevice,RCGasMeasureDeviceProxy>() {
        public RCGasMeasureDeviceProxy apply(final UIGasMeasureDevice it) {
          RCGasMeasureDeviceProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<RCGasMeasureDeviceProxy> ac = _actionContext.<RCGasMeasureDeviceProxy>adapt(new Function<UIGasMeasureDevice,RCGasMeasureDeviceProxy>() {
        public RCGasMeasureDeviceProxy apply(UIGasMeasureDevice input) {
          return _function.apply(input);
        }
    });
    ContentPanel _ContentPanel = this.widgets.ContentPanel();
    final Procedure1<ContentPanel> _function_1 = new Procedure1<ContentPanel>() {
        public void apply(final ContentPanel it) {
          GasMeasureDeviceListPresenterView _view = GasMeasureDeviceManagementView.this.queryListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          final Function0<RCGasMeasureDeviceTypeProxy> _function = new Function0<RCGasMeasureDeviceTypeProxy>() {
              public RCGasMeasureDeviceTypeProxy apply() {
                return GasMeasureDeviceManagementView.this.context;
              }
            };
          it.<RCGasMeasureDeviceTypeProxy>addCommand(_function, GasMeasureDeviceManagementView.this.createGasMeasureDeviceCommand);
          it.addCommand(ac, GasMeasureDeviceManagementView.this.updateGasMeasureDeviceCommand);
          it.addCommand(ac, GasMeasureDeviceManagementView.this.deleteGasMeasureDeviceCommand);
        }
      };
    ContentPanel _doubleArrow = ObjectExtensions.<ContentPanel>operator_doubleArrow(_ContentPanel, _function_1);
    this.con = _doubleArrow;
  }
  
  public void setContext(final RCGasMeasureDeviceTypeProxy context) {
    this.context = context;
  }
}
