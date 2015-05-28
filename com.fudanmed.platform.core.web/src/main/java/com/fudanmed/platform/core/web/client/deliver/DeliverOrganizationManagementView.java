package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateDeliverOrganizationCommand;
import com.fudanmed.platform.core.web.client.deliver.DeleteDeliverOrganizationCommand;
import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationQueryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.UpdateDeliverOrganizationCommand;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.common.client.widget.GWTAbstractView;
import edu.fudan.langlab.gxt.client.widget.FramedPanel;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeliverOrganizationManagementView extends GWTAbstractView implements DeliverOrganizationManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(createDeliverOrganizationCommand,updateDeliverOrganizationCommand,deleteDeliverOrganizationCommand),
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
  
  private DeliverOrganizationQueryListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final DeliverOrganizationQueryListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  @Inject
  private CreateDeliverOrganizationCommand createDeliverOrganizationCommand;
  
  @Inject
  private UpdateDeliverOrganizationCommand updateDeliverOrganizationCommand;
  
  @Inject
  private DeleteDeliverOrganizationCommand deleteDeliverOrganizationCommand;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    DeliverOrganizationQueryListPresenterView _view = this.queryListPresenter.getView();
    ActionContext<UIDeliverOrganization> _actionContext = _view.getActionContext();
    final Function1<UIDeliverOrganization,DLDeliverOrganizationProxy> _function = new Function1<UIDeliverOrganization,DLDeliverOrganizationProxy>() {
        public DLDeliverOrganizationProxy apply(final UIDeliverOrganization it) {
          DLDeliverOrganizationProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<DLDeliverOrganizationProxy> ac = _actionContext.<DLDeliverOrganizationProxy>adapt(new Function<UIDeliverOrganization,DLDeliverOrganizationProxy>() {
        public DLDeliverOrganizationProxy apply(UIDeliverOrganization input) {
          return _function.apply(input);
        }
    });
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u8FD0\u9001\u90E8\u95E8\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function_1 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          DeliverOrganizationQueryListPresenterView _view = DeliverOrganizationManagementView.this.queryListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          it.addCommand(DeliverOrganizationManagementView.this.createDeliverOrganizationCommand);
          it.addCommand(ac, DeliverOrganizationManagementView.this.updateDeliverOrganizationCommand);
          it.addCommand(ac, DeliverOrganizationManagementView.this.deleteDeliverOrganizationCommand);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_1);
    this.con = _doubleArrow;
  }
}
