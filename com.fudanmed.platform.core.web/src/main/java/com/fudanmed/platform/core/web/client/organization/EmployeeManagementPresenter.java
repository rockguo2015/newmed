package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.ChangeEmployeeDepartmentPresenter;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateEmployeePresenter;
import com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenterView;
import com.fudanmed.platform.core.web.client.organization.EmployeeUploaderPresenter;
import com.fudanmed.platform.core.web.client.organization.ResetPasswdPresenter;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIEmployeeCriteria;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.langlab.gxt.client.dialog.DialogPresenterExtensions;
import edu.fudan.langlab.uidl.domain.app.client.security.SelectRoles4UserPresenter;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class EmployeeManagementPresenter extends WorkbenchAbstractPresenter<EmployeeManagementPresenterView> {
  @Inject
  protected EmployeeManagementPresenterServiceAsync _service;
  
  @Inject
  public EmployeeManagementPresenter(final EmployeeManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateEmployeePresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<SelectRoles4UserPresenter> selectRoles4UserPresenter;
  
  @Inject
  private Provider<EmployeeUploaderPresenter> employeeUploaderPresenter;
  
  @Inject
  private Provider<ResetPasswdPresenter> resetPasswdPresenter;
  
  @Inject
  private Provider<ChangeEmployeeDepartmentPresenter> modifyDepartment;
  
  public void onStartExecution() {
    
    final Procedure1<Collection<UIOrganization>> _function = new Procedure1<Collection<UIOrganization>>() {
        public void apply(final Collection<UIOrganization> it) {
          getView().showOutlineDatas(it);
          getView().refresh();
          
        }
      };
    AsyncCallback<Collection<UIOrganization>> _onSuccess = this.<Collection<UIOrganization>>onSuccess(_function);
    _service.getAllOrganization(_onSuccess);
  }
  
  public void view_createRequestExecution(final RCOrganizationProxy org) {
    
    CreateOrUpdateEmployeePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateEmployeePresenter> _function = new Procedure1<CreateOrUpdateEmployeePresenter>() {
        public void apply(final CreateOrUpdateEmployeePresenter it) {
          final Procedure1<CreateOrUpdateEmployeePresenter> _function = new Procedure1<CreateOrUpdateEmployeePresenter>() {
              public void apply(final CreateOrUpdateEmployeePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(org, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateEmployeePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void _eventbus_InputNextEmployee(final RCOrganizationProxy org) {
    
    CreateOrUpdateEmployeePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateEmployeePresenter> _function = new Procedure1<CreateOrUpdateEmployeePresenter>() {
        public void apply(final CreateOrUpdateEmployeePresenter it) {
          final Procedure1<CreateOrUpdateEmployeePresenter> _function = new Procedure1<CreateOrUpdateEmployeePresenter>() {
              public void apply(final CreateOrUpdateEmployeePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(org, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateEmployeePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCEmployeeProxy value) {
    
    CreateOrUpdateEmployeePresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateEmployeePresenter> _function = new Procedure1<CreateOrUpdateEmployeePresenter>() {
        public void apply(final CreateOrUpdateEmployeePresenter it) {
          final Procedure1<CreateOrUpdateEmployeePresenter> _function = new Procedure1<CreateOrUpdateEmployeePresenter>() {
              public void apply(final CreateOrUpdateEmployeePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateEmployeePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyDepartmentExecution(final RCEmployeeProxy value) {
    
    ChangeEmployeeDepartmentPresenter _get = this.modifyDepartment.get();
    final Procedure1<ChangeEmployeeDepartmentPresenter> _function = new Procedure1<ChangeEmployeeDepartmentPresenter>() {
        public void apply(final ChangeEmployeeDepartmentPresenter it) {
          final Procedure1<ChangeEmployeeDepartmentPresenter> _function = new Procedure1<ChangeEmployeeDepartmentPresenter>() {
              public void apply(final ChangeEmployeeDepartmentPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(value, new IPresenterInitiazerNotifier<ChangeEmployeeDepartmentPresenter>() {
              public void done(ChangeEmployeeDepartmentPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<ChangeEmployeeDepartmentPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_resetPasswdRequestExecution(final RCEmployeeProxy value) {
    
    final Procedure1<UserProxy> _function = new Procedure1<UserProxy>() {
        public void apply(final UserProxy user) {
          ResetPasswdPresenter _get = EmployeeManagementPresenter.this.resetPasswdPresenter.get();
          final Procedure1<ResetPasswdPresenter> _function = new Procedure1<ResetPasswdPresenter>() {
              public void apply(final ResetPasswdPresenter it) {
                it.popup(it);
              }
            };
          _get.setup(user, new IPresenterInitiazerNotifier<ResetPasswdPresenter>() {
              public void done(ResetPasswdPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    AsyncCallback<UserProxy> _onSuccess = this.<UserProxy>onSuccess(_function);
    _service.asUser(value, _onSuccess);
  }
  
  public void view_deleteRequestExecution(final RCEmployeeProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.EmployeesChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void view_assignRolesRequestExecution(final RCEmployeeProxy value) {
    
    final Procedure1<UserProxy> _function = new Procedure1<UserProxy>() {
        public void apply(final UserProxy user) {
          SelectRoles4UserPresenter _get = EmployeeManagementPresenter.this.selectRoles4UserPresenter.get();
          final Procedure1<SelectRoles4UserPresenter> _function = new Procedure1<SelectRoles4UserPresenter>() {
              public void apply(final SelectRoles4UserPresenter it) {
                final Procedure1<SelectRoles4UserPresenter> _function = new Procedure1<SelectRoles4UserPresenter>() {
                    public void apply(final SelectRoles4UserPresenter it) {
                      eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                      
                    }
                  };
                it.setup(user, _function);
              }
            };
          ObjectExtensions.<SelectRoles4UserPresenter>operator_doubleArrow(_get, _function);
        }
      };
    AsyncCallback<UserProxy> _onSuccess = this.<UserProxy>onSuccess(_function);
    _service.asUser(value, _onSuccess);
  }
  
  public void view_filterRequestExecution(final UIEmployeeCriteria c) {
    
    final Procedure1<IPagedResult<UIEmployee>> _function = new Procedure1<IPagedResult<UIEmployee>>() {
        public void apply(final IPagedResult<UIEmployee> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIEmployee>> _onSuccess = this.<IPagedResult<UIEmployee>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_EmployeesChanged() {
    getView().refresh();
    
  }
  
  public void view_organizationSelectedExecution(final RCOrganizationProxy org, final UIEmployeeCriteria c) {
    
    final Procedure1<IPagedResult<UIEmployee>> _function = new Procedure1<IPagedResult<UIEmployee>>() {
        public void apply(final IPagedResult<UIEmployee> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIEmployee>> _onSuccess = this.<IPagedResult<UIEmployee>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_leaveJobRequestExecution(final RCEmployeeProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.EmployeesChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.leaveJob(value, _onSuccess);
  }
  
  public void view_resumeJobRequestExecution(final RCEmployeeProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.EmployeesChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.resumeJob(value, _onSuccess);
  }
  
  public void view_importRequestExecution() {
    
    EmployeeUploaderPresenter _get = this.employeeUploaderPresenter.get();
    DialogPresenterExtensions.asDialog(_get, "\u5458\u5DE5\u4FE1\u606F\u5BFC\u5165");
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler1<RCOrganizationProxy>(){
    			
    			public void execute(RCOrganizationProxy org){
    				view_createRequestExecution(org);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.InputNextEmployeeEvent.__type__, new com.fudanmed.platform.core.web.client.organization.InputNextEmployeeHandler(){
    public void InputNextEmployee(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy org){
    	_eventbus_InputNextEmployee(org);
    }
    }));
    getView().modifyRequest(new RequestHandler1<RCEmployeeProxy>(){
    			
    			public void execute(RCEmployeeProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().modifyDepartment(new RequestHandler1<RCEmployeeProxy>(){
    			
    			public void execute(RCEmployeeProxy value){
    				view_modifyDepartmentExecution(value);
    			}
    			
    		});
    getView().resetPasswdRequest(new RequestHandler1<RCEmployeeProxy>(){
    			
    			public void execute(RCEmployeeProxy value){
    				view_resetPasswdRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCEmployeeProxy>(){
    			
    			public void execute(RCEmployeeProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    getView().assignRolesRequest(new RequestHandler1<RCEmployeeProxy>(){
    			
    			public void execute(RCEmployeeProxy value){
    				view_assignRolesRequestExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UIEmployeeCriteria>(){
    			
    			public void execute(UIEmployeeCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.EmployeesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.EmployeesChangedHandler(){
    public void EmployeesChanged(){
    	_eventbus_EmployeesChanged();
    }
    }));
    getView().organizationSelected(new RequestHandler2<RCOrganizationProxy,UIEmployeeCriteria>(){
    			
    			public void execute(RCOrganizationProxy org,UIEmployeeCriteria c){
    				view_organizationSelectedExecution(org,c);
    			}
    			
    		});
    getView().leaveJobRequest(new RequestHandler1<RCEmployeeProxy>(){
    			
    			public void execute(RCEmployeeProxy value){
    				view_leaveJobRequestExecution(value);
    			}
    			
    		});
    getView().resumeJobRequest(new RequestHandler1<RCEmployeeProxy>(){
    			
    			public void execute(RCEmployeeProxy value){
    				view_resumeJobRequestExecution(value);
    			}
    			
    		});
    getView().importRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_importRequestExecution();
    			}
    			
    		});
    onStartExecution();
    
  }
}
