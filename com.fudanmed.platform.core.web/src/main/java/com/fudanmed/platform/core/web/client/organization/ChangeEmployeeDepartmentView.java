package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.ChangeEmployeeDepartmentPresenterView;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.uniquesoft.gwt.client.ClientUi;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ObjectSelectionProviders;
import com.uniquesoft.gwt.client.common.widgets.IHasSize;
import com.uniquesoft.gwt.client.common.widgets.IHasTitle;
import com.uniquesoft.gwt.client.common.widgets.Size;
import edu.fudan.langlab.gxt.client.validation.ErrorNotifierViewer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.security.client.Securities;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ChangeEmployeeDepartmentView extends ErrorNotifierViewer implements ChangeEmployeeDepartmentPresenterView, IHasSize, IHasTitle {
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
    return new com.uniquesoft.gwt.client.common.widgets.Size(300,400);
  }
  
  public String getTitle() {
    return "部门变动";
  }
  
  private OrganizationOutlinePresenter organizationOutlinePresenter;
  
  public void setOrganizationOutlinePresenter(final OrganizationOutlinePresenter organizationOutlinePresenter) {
    this.organizationOutlinePresenter = organizationOutlinePresenter;
  }
  
  private ActionContext<UIOrganization> actionContext;
  
  private Label oldDepartmentMsg;
  
  public void initialize() {
    
    VerticalLayoutContainer _VLayout = this.widgets.VLayout();
    final Procedure1<VerticalLayoutContainer> _function = new Procedure1<VerticalLayoutContainer>() {
        public void apply(final VerticalLayoutContainer it) {
          Label _Label = ChangeEmployeeDepartmentView.this.widgets.Label("");
          Label _oldDepartmentMsg = ChangeEmployeeDepartmentView.this.oldDepartmentMsg = _Label;
          it.add(_oldDepartmentMsg);
          OrganizationOutlinePresenterView _view = ChangeEmployeeDepartmentView.this.organizationOutlinePresenter.getView();
          Widget _asWidget = _view.asWidget();
          VerticalLayoutData _VLayoutData = ChangeEmployeeDepartmentView.this.widgets.VLayoutData(1, 300);
          it.add(_asWidget, _VLayoutData);
        }
      };
    VerticalLayoutContainer _doubleArrow = ObjectExtensions.<VerticalLayoutContainer>operator_doubleArrow(_VLayout, _function);
    ClientUi.operator_add(this, _doubleArrow);
    OrganizationOutlinePresenterView _view = this.organizationOutlinePresenter.getView();
    ActionContext<UIOrganization> _actionContext = _view.getActionContext();
    this.actionContext = _actionContext;
  }
  
  public RCOrganizationProxy getNewOrganization() {
    UIOrganization _onlySelected = ObjectSelectionProviders.<UIOrganization>getOnlySelected(this.actionContext);
    RCOrganizationProxy _proxy = _onlySelected==null?(RCOrganizationProxy)null:_onlySelected.toProxy();
    return _proxy;
  }
  
  public void setOldOrganization(final UIOrganization oldOrg) {
    String _name = oldOrg.getName();
    String _plus = ("\u5F53\u524D\u90E8\u95E8:" + _name);
    this.oldDepartmentMsg.setText(_plus);
  }
}
