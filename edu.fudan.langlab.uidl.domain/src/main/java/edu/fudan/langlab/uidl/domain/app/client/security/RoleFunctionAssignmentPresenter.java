package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateAppFunctionAssignmentPresenter;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenterServiceAsync;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunction;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RoleFunctionAssignmentPresenter extends WorkbenchAbstractPresenter<RoleFunctionAssignmentPresenterView> {
  @Inject
  protected RoleFunctionAssignmentPresenterServiceAsync _service;
  
  @Inject
  public RoleFunctionAssignmentPresenter(final RoleFunctionAssignmentPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateAppFunctionAssignmentPresenter> createOrUpdateAppFunctionAssignmentPresenter;
  
  public void setup(final Procedure1<? super RoleFunctionAssignmentPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIAppRole>> _function = new Procedure1<Collection<UIAppRole>>() {
              public void apply(final Collection<UIAppRole> it) {
                getView().showRoles(it);
                
                postInit.apply(RoleFunctionAssignmentPresenter.this);
              }
            };
          AsyncCallback<Collection<UIAppRole>> _onSuccess = RoleFunctionAssignmentPresenter.this.<Collection<UIAppRole>>onSuccess(_function);
          _service.getAllRoles(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_showRoleFunctionsRequestExecution(final UIAppRole role) {
    
    String _roleId = role.getRoleId();
    final Procedure1<Collection<UIAppFunction>> _function = new Procedure1<Collection<UIAppFunction>>() {
        public void apply(final Collection<UIAppFunction> it) {
          getView().showFunctions(it);
          
        }
      };
    AsyncCallback<Collection<UIAppFunction>> _onSuccess = this.<Collection<UIAppFunction>>onSuccess(_function);
    _service.getFunctions4Role(_roleId, _onSuccess);
  }
  
  public void view_modifyAssignmentRequestExecution(final UIAppRole role) {
    
    CreateOrUpdateAppFunctionAssignmentPresenter _get = this.createOrUpdateAppFunctionAssignmentPresenter.get();
    final Procedure1<CreateOrUpdateAppFunctionAssignmentPresenter> _function = new Procedure1<CreateOrUpdateAppFunctionAssignmentPresenter>() {
        public void apply(final CreateOrUpdateAppFunctionAssignmentPresenter it) {
          final Procedure1<CreateOrUpdateAppFunctionAssignmentPresenter> _function = new Procedure1<CreateOrUpdateAppFunctionAssignmentPresenter>() {
              public void apply(final CreateOrUpdateAppFunctionAssignmentPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(role, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateAppFunctionAssignmentPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void _eventbus_AppFunctionAssignmentsChanged(final UIAppRole role) {
    
    String _roleId = role.getRoleId();
    final Procedure1<Collection<UIAppFunction>> _function = new Procedure1<Collection<UIAppFunction>>() {
        public void apply(final Collection<UIAppFunction> it) {
          getView().showFunctions(it);
          
        }
      };
    AsyncCallback<Collection<UIAppFunction>> _onSuccess = this.<Collection<UIAppFunction>>onSuccess(_function);
    _service.getFunctions4Role(_roleId, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().showRoleFunctionsRequest(new RequestHandler1<UIAppRole>(){
    			
    			public void execute(UIAppRole role){
    				view_showRoleFunctionsRequestExecution(role);
    			}
    			
    		});
    getView().modifyAssignmentRequest(new RequestHandler1<UIAppRole>(){
    			
    			public void execute(UIAppRole role){
    				view_modifyAssignmentRequestExecution(role);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(edu.fudan.langlab.uidl.domain.app.client.security.AppFunctionAssignmentsChangedEvent.__type__, new edu.fudan.langlab.uidl.domain.app.client.security.AppFunctionAssignmentsChangedHandler(){
    public void AppFunctionAssignmentsChanged(edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole role){
    	_eventbus_AppFunctionAssignmentsChanged(role);
    }
    }));
    
  }
}
