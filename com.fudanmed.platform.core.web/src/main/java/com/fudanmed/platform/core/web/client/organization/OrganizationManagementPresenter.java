package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOrganizationPresenter;
import com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.OrganizationManagementPresenterView;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OrganizationUploaderPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.gxt.client.dialog.DialogPresenterExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class OrganizationManagementPresenter extends WorkbenchAbstractPresenter<OrganizationManagementPresenterView> {
  @Inject
  protected OrganizationManagementPresenterServiceAsync _service;
  
  @Inject
  public OrganizationManagementPresenter(final OrganizationManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateOrganizationPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<OrganizationUploaderPresenter> organizationUploaderPresenter;
  
  @Inject
  private OrganizationOutlinePresenter organizationOutlinePresenter;
  
  public void setup(final Procedure1<? super OrganizationManagementPresenter> postInit) {
    
    final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
        public void apply(final OrganizationOutlinePresenter it) {
          getView().setOrganizationOutlinePresenter(it);
          
          OrganizationManagementPresenter.this.registerPart(it);
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                postInit.apply(OrganizationManagementPresenter.this);
              }
            };
          OrganizationManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    this.organizationOutlinePresenter.setup(_function);
  }
  
  public void view_createRequestExecution(final RCOrganizationProxy parent) {
    
    CreateOrUpdateOrganizationPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateOrganizationPresenter> _function = new Procedure1<CreateOrUpdateOrganizationPresenter>() {
        public void apply(final CreateOrUpdateOrganizationPresenter it) {
          final Procedure1<CreateOrUpdateOrganizationPresenter> _function = new Procedure1<CreateOrUpdateOrganizationPresenter>() {
              public void apply(final CreateOrUpdateOrganizationPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateOrganizationPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void _eventbus_InputNextOrganization(final RCOrganizationProxy parent) {
    
    CreateOrUpdateOrganizationPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateOrganizationPresenter> _function = new Procedure1<CreateOrUpdateOrganizationPresenter>() {
        public void apply(final CreateOrUpdateOrganizationPresenter it) {
          final Procedure1<CreateOrUpdateOrganizationPresenter> _function = new Procedure1<CreateOrUpdateOrganizationPresenter>() {
              public void apply(final CreateOrUpdateOrganizationPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateOrganizationPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCOrganizationProxy value) {
    
    CreateOrUpdateOrganizationPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateOrganizationPresenter> _function = new Procedure1<CreateOrUpdateOrganizationPresenter>() {
        public void apply(final CreateOrUpdateOrganizationPresenter it) {
          final Procedure1<CreateOrUpdateOrganizationPresenter> _function = new Procedure1<CreateOrUpdateOrganizationPresenter>() {
              public void apply(final CreateOrUpdateOrganizationPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateOrganizationPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRequestExecution(final RCOrganizationProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.OrganizationDeletedEvent(value));
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void view_importRequestExecution() {
    
    OrganizationUploaderPresenter _get = this.organizationUploaderPresenter.get();
    DialogPresenterExtensions.asDialog(_get, "\u5BFC\u5165\u673A\u6784\u4FE1\u606F");
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler1<RCOrganizationProxy>(){
    			
    			public void execute(RCOrganizationProxy parent){
    				view_createRequestExecution(parent);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.InputNextOrganizationEvent.__type__, new com.fudanmed.platform.core.web.client.organization.InputNextOrganizationHandler(){
    public void InputNextOrganization(com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy parent){
    	_eventbus_InputNextOrganization(parent);
    }
    }));
    getView().modifyRequest(new RequestHandler1<RCOrganizationProxy>(){
    			
    			public void execute(RCOrganizationProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCOrganizationProxy>(){
    			
    			public void execute(RCOrganizationProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    getView().importRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_importRequestExecution();
    			}
    			
    		});
    
  }
}
