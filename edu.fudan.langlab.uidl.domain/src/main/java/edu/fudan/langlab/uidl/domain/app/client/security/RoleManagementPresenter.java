package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateRolePresenter;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenterServiceAsync;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RoleManagementPresenter extends WorkbenchAbstractPresenter<RoleManagementPresenterView> {
  @Inject
  protected RoleManagementPresenterServiceAsync _service;
  
  @Inject
  public RoleManagementPresenter(final RoleManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateRolePresenter> createOrUpdateRolePresenter;
  
  public void setup(final Procedure1<? super RoleManagementPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIRole>> _function = new Procedure1<Collection<UIRole>>() {
              public void apply(final Collection<UIRole> items) {
                getView().setResults(items);
                
                postInit.apply(RoleManagementPresenter.this);
              }
            };
          AsyncCallback<Collection<UIRole>> _onSuccess = RoleManagementPresenter.this.<Collection<UIRole>>onSuccess(_function);
          _service.loadRoleList(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void refresh() {
    
    final Procedure1<Collection<UIRole>> _function = new Procedure1<Collection<UIRole>>() {
        public void apply(final Collection<UIRole> items) {
          getView().setResults(items);
          
        }
      };
    AsyncCallback<Collection<UIRole>> _onSuccess = this.<Collection<UIRole>>onSuccess(_function);
    _service.loadRoleList(_onSuccess);
  }
  
  public void _eventbus_RolesChanged() {
    
    this.refresh();
  }
  
  public void view_createRoleRequestExecution() {
    
    CreateOrUpdateRolePresenter _get = this.createOrUpdateRolePresenter.get();
    final Procedure1<CreateOrUpdateRolePresenter> _function = new Procedure1<CreateOrUpdateRolePresenter>() {
        public void apply(final CreateOrUpdateRolePresenter it) {
          final Procedure1<CreateOrUpdateRolePresenter> _function = new Procedure1<CreateOrUpdateRolePresenter>() {
              public void apply(final CreateOrUpdateRolePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(_function);
        }
      };
    ObjectExtensions.<CreateOrUpdateRolePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void _eventbus_InputNextRole() {
    
    CreateOrUpdateRolePresenter _get = this.createOrUpdateRolePresenter.get();
    final Procedure1<CreateOrUpdateRolePresenter> _function = new Procedure1<CreateOrUpdateRolePresenter>() {
        public void apply(final CreateOrUpdateRolePresenter it) {
          final Procedure1<CreateOrUpdateRolePresenter> _function = new Procedure1<CreateOrUpdateRolePresenter>() {
              public void apply(final CreateOrUpdateRolePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(_function);
        }
      };
    ObjectExtensions.<CreateOrUpdateRolePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRoleRequestExecution(final RoleProxy role) {
    
    CreateOrUpdateRolePresenter _get = this.createOrUpdateRolePresenter.get();
    final Procedure1<CreateOrUpdateRolePresenter> _function = new Procedure1<CreateOrUpdateRolePresenter>() {
        public void apply(final CreateOrUpdateRolePresenter it) {
          final Procedure1<CreateOrUpdateRolePresenter> _function = new Procedure1<CreateOrUpdateRolePresenter>() {
              public void apply(final CreateOrUpdateRolePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(role, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateRolePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRoleRequestExecution(final RoleProxy role) {
    
    final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
        public void apply(final Boolean canDelete) {
          if ((canDelete).booleanValue()) {
            final Procedure1<Void> _function = new Procedure1<Void>() {
                public void apply(final Void it) {eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.security.RolesChangedEvent());
                  
                }
              };
            AsyncCallback<Void> _onSuccess = RoleManagementPresenter.this.<Void>onSuccess(_function);
            _service.delete(role, _onSuccess);
          } else {
            Info.display("\u9519\u8BEF", "\u8BE5\u89D2\u8272\u5DF2\u6709\u7528\u6237\u4F7F\u7528\uFF0C\u65E0\u6CD5\u5220\u9664");
          }
        }
      };
    AsyncCallback<Boolean> _onSuccess = this.<Boolean>onSuccess(_function);
    _service.canDelete(role, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(edu.fudan.langlab.uidl.domain.app.client.security.RolesChangedEvent.__type__, new edu.fudan.langlab.uidl.domain.app.client.security.RolesChangedHandler(){
    public void RolesChanged(){
    	_eventbus_RolesChanged();
    }
    }));
    getView().createRoleRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_createRoleRequestExecution();
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(edu.fudan.langlab.uidl.domain.app.client.security.InputNextRoleEvent.__type__, new edu.fudan.langlab.uidl.domain.app.client.security.InputNextRoleHandler(){
    public void InputNextRole(){
    	_eventbus_InputNextRole();
    }
    }));
    getView().modifyRoleRequest(new RequestHandler1<RoleProxy>(){
    			
    			public void execute(RoleProxy role){
    				view_modifyRoleRequestExecution(role);
    			}
    			
    		});
    getView().deleteRoleRequest(new RequestHandler1<RoleProxy>(){
    			
    			public void execute(RoleProxy role){
    				view_deleteRoleRequestExecution(role);
    			}
    			
    		});
    
  }
}
