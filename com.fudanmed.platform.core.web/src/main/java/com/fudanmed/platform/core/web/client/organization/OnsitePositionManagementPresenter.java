package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateOnsitePositionPresenter;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenterView;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionUploaderPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.gxt.client.dialog.DialogPresenterExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class OnsitePositionManagementPresenter extends WorkbenchAbstractPresenter<OnsitePositionManagementPresenterView> {
  @Inject
  protected OnsitePositionManagementPresenterServiceAsync _service;
  
  @Inject
  public OnsitePositionManagementPresenter(final OnsitePositionManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateOnsitePositionPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<OnsitePositionUploaderPresenter> onsitePositionUploaderPresenter;
  
  @Inject
  private OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter;
  
  public void setup(final Procedure1<? super OnsitePositionManagementPresenter> postInit) {
    
    final Procedure1<OnsiteLocationOutlinePresenter> _function = new Procedure1<OnsiteLocationOutlinePresenter>() {
        public void apply(final OnsiteLocationOutlinePresenter it) {
          getView().setOnsiteLocationOutlinePresenter(it);
          
          OnsitePositionManagementPresenter.this.registerPart(it);
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                postInit.apply(OnsitePositionManagementPresenter.this);
              }
            };
          OnsitePositionManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    this.onsiteLocationOutlinePresenter.setup(_function);
  }
  
  public void view_createRequestExecution(final RCOnsitePositionProxy parent) {
    
    CreateOrUpdateOnsitePositionPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateOnsitePositionPresenter> _function = new Procedure1<CreateOrUpdateOnsitePositionPresenter>() {
        public void apply(final CreateOrUpdateOnsitePositionPresenter it) {
          final Procedure1<CreateOrUpdateOnsitePositionPresenter> _function = new Procedure1<CreateOrUpdateOnsitePositionPresenter>() {
              public void apply(final CreateOrUpdateOnsitePositionPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, new IPresenterInitiazerNotifier<CreateOrUpdateOnsitePositionPresenter>() {
              public void done(CreateOrUpdateOnsitePositionPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateOnsitePositionPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void _eventbus_InputNextOnsitePosition(final RCOnsitePositionProxy parent) {
    
    CreateOrUpdateOnsitePositionPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateOnsitePositionPresenter> _function = new Procedure1<CreateOrUpdateOnsitePositionPresenter>() {
        public void apply(final CreateOrUpdateOnsitePositionPresenter it) {
          final Procedure1<CreateOrUpdateOnsitePositionPresenter> _function = new Procedure1<CreateOrUpdateOnsitePositionPresenter>() {
              public void apply(final CreateOrUpdateOnsitePositionPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(parent, new IPresenterInitiazerNotifier<CreateOrUpdateOnsitePositionPresenter>() {
              public void done(CreateOrUpdateOnsitePositionPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateOnsitePositionPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCOnsitePositionProxy value) {
    
    CreateOrUpdateOnsitePositionPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateOnsitePositionPresenter> _function = new Procedure1<CreateOrUpdateOnsitePositionPresenter>() {
        public void apply(final CreateOrUpdateOnsitePositionPresenter it) {
          final Procedure1<CreateOrUpdateOnsitePositionPresenter> _function = new Procedure1<CreateOrUpdateOnsitePositionPresenter>() {
              public void apply(final CreateOrUpdateOnsitePositionPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateOnsitePositionPresenter>() {
              public void done(CreateOrUpdateOnsitePositionPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateOnsitePositionPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRequestExecution(final RCOnsitePositionProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.OnsitePositionDeletedEvent(value));
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void view_importRequestExecution() {
    
    OnsitePositionUploaderPresenter _get = this.onsitePositionUploaderPresenter.get();
    DialogPresenterExtensions.asDialog(_get, "\u5BFC\u5165\u4F4D\u7F6E\u4FE1\u606F");
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler1<RCOnsitePositionProxy>(){
    			
    			public void execute(RCOnsitePositionProxy parent){
    				view_createRequestExecution(parent);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.InputNextOnsitePositionEvent.__type__, new com.fudanmed.platform.core.web.client.organization.InputNextOnsitePositionHandler(){
    public void InputNextOnsitePosition(com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy parent){
    	_eventbus_InputNextOnsitePosition(parent);
    }
    }));
    getView().modifyRequest(new RequestHandler1<RCOnsitePositionProxy>(){
    			
    			public void execute(RCOnsitePositionProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCOnsitePositionProxy>(){
    			
    			public void execute(RCOnsitePositionProxy value){
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
