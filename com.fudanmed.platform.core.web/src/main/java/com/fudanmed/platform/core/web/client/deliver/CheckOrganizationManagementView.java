package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationQueryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationQueryListPresenterView;
import com.fudanmed.platform.core.web.client.deliver.CreateCheckOrganizationCommand;
import com.fudanmed.platform.core.web.client.deliver.DeleteCheckOrganizationCommand;
import com.fudanmed.platform.core.web.client.deliver.UpdateCheckOrganizationCommand;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
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

public class CheckOrganizationManagementView extends GWTAbstractView implements CheckOrganizationManagementPresenterView {
  @Inject
  private IWidgetFactory widgets;
  
  public void initialize(final IPostInitializeAction postInitialize) {
    com.uniquesoft.gwt.client.common.async.InitializerManager.initialize(
    	com.google.common.collect.Lists.newArrayList(createCheckOrganizationCommand,updateCheckOrganizationCommand,deleteCheckOrganizationCommand),
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
  
  private CheckOrganizationQueryListPresenter queryListPresenter;
  
  public void setQueryListPresenter(final CheckOrganizationQueryListPresenter queryListPresenter) {
    this.queryListPresenter = queryListPresenter;
  }
  
  @Inject
  private CreateCheckOrganizationCommand createCheckOrganizationCommand;
  
  @Inject
  private UpdateCheckOrganizationCommand updateCheckOrganizationCommand;
  
  @Inject
  private DeleteCheckOrganizationCommand deleteCheckOrganizationCommand;
  
  private Widget con;
  
  public Widget asWidget() {
    return this.con;
  }
  
  public void initialize() {
    
    CheckOrganizationQueryListPresenterView _view = this.queryListPresenter.getView();
    ActionContext<UICheckOrganization> _actionContext = _view.getActionContext();
    final Function1<UICheckOrganization,DLCheckOrganizationProxy> _function = new Function1<UICheckOrganization,DLCheckOrganizationProxy>() {
        public DLCheckOrganizationProxy apply(final UICheckOrganization it) {
          DLCheckOrganizationProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    final ActionContext<DLCheckOrganizationProxy> ac = _actionContext.<DLCheckOrganizationProxy>adapt(new Function<UICheckOrganization,DLCheckOrganizationProxy>() {
        public DLCheckOrganizationProxy apply(UICheckOrganization input) {
          return _function.apply(input);
        }
    });
    FramedPanel _FramedPanel = this.widgets.FramedPanel("\u68C0\u67E5\u79D1\u5BA4\u7EF4\u62A4");
    final Procedure1<FramedPanel> _function_1 = new Procedure1<FramedPanel>() {
        public void apply(final FramedPanel it) {
          CheckOrganizationQueryListPresenterView _view = CheckOrganizationManagementView.this.queryListPresenter.getView();
          Widget _asWidget = _view.asWidget();
          it.setWidget(_asWidget);
          it.addCommand(CheckOrganizationManagementView.this.createCheckOrganizationCommand);
          it.addCommand(ac, CheckOrganizationManagementView.this.updateCheckOrganizationCommand);
          it.addCommand(ac, CheckOrganizationManagementView.this.deleteCheckOrganizationCommand);
        }
      };
    FramedPanel _doubleArrow = ObjectExtensions.<FramedPanel>operator_doubleArrow(_FramedPanel, _function_1);
    this.con = _doubleArrow;
  }
}
