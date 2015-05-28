package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.ChangeEmployeeDepartmentPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.ChangeEmployeeDepartmentPresenterView;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ChangeEmployeeDepartmentPresenter extends WorkbenchAbstractPresenter<ChangeEmployeeDepartmentPresenterView> implements CommitablePresenter {
  @Inject
  protected ChangeEmployeeDepartmentPresenterServiceAsync _service;
  
  @Inject
  public ChangeEmployeeDepartmentPresenter(final ChangeEmployeeDepartmentPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCEmployeeProxy value;
  
  public OrganizationOutlinePresenter initPart(final OrganizationOutlinePresenter part) {
    this.registerPart(part);
    this.getView().setOrganizationOutlinePresenter(part);
    return part;
    
  }
  
  @Inject
  private OrganizationOutlinePresenter organizationOutlinePresenter;
  
  public void setup(final RCEmployeeProxy value, final IPresenterInitiazerNotifier<ChangeEmployeeDepartmentPresenter> _notifier) {
    
    this.value = value;
    OrganizationOutlinePresenter _initPart = this.initPart(this.organizationOutlinePresenter);
    final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
        public void apply(final OrganizationOutlinePresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                final Procedure1<UIOrganization> _function = new Procedure1<UIOrganization>() {
                    public void apply(final UIOrganization it) {
                      ChangeEmployeeDepartmentPresenterView _view = ChangeEmployeeDepartmentPresenter.this.getView();
                      _view.setOldOrganization(it);_notifier.done(ChangeEmployeeDepartmentPresenter.this);
                    }
                  };
                AsyncCallback<UIOrganization> _onSuccess = ChangeEmployeeDepartmentPresenter.this.<UIOrganization>onSuccess(_function);
                _service.getOrganization4Employee(value, _onSuccess);
              }
            };
          ChangeEmployeeDepartmentPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setupAsSimpleTree(_function);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    ChangeEmployeeDepartmentPresenterView _view = this.getView();
    RCOrganizationProxy _newOrganization = _view.getNewOrganization();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.EmployeesChangedEvent());
          
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.changeOrganization(this.value, _newOrganization, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    
  }
}
