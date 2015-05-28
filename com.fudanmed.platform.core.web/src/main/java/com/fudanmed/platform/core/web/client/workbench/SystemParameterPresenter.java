package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.workbench.CreateOrUpdateSystemParameterPresenter;
import com.fudanmed.platform.core.web.client.workbench.SystemParameterPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.workbench.SystemParameterPresenterView;
import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SystemParameterPresenter extends WorkbenchAbstractPresenter<SystemParameterPresenterView> {
  @Inject
  protected SystemParameterPresenterServiceAsync _service;
  
  @Inject
  public SystemParameterPresenter(final SystemParameterPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateSystemParameterPresenter> createOrUpdateSystemParameterPresenter;
  
  public void setup(final Procedure1<? super SystemParameterPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UISystemParameter> _function = new Procedure1<UISystemParameter>() {
              public void apply(final UISystemParameter it) {
                getView().showParameter(it);
                
                postInit.apply(SystemParameterPresenter.this);
              }
            };
          AsyncCallback<UISystemParameter> _onSuccess = SystemParameterPresenter.this.<UISystemParameter>onSuccess(_function);
          _service.loadParameter(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_modifyParameterRequestExecution() {
    
    CreateOrUpdateSystemParameterPresenter _get = this.createOrUpdateSystemParameterPresenter.get();
    final Procedure1<CreateOrUpdateSystemParameterPresenter> _function = new Procedure1<CreateOrUpdateSystemParameterPresenter>() {
        public void apply(final CreateOrUpdateSystemParameterPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup(_function);
  }
  
  public void _eventbus_SystemParametersChanged() {
    
    final Procedure1<UISystemParameter> _function = new Procedure1<UISystemParameter>() {
        public void apply(final UISystemParameter it) {
          getView().showParameter(it);
          
        }
      };
    AsyncCallback<UISystemParameter> _onSuccess = this.<UISystemParameter>onSuccess(_function);
    _service.loadParameter(_onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().modifyParameterRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_modifyParameterRequestExecution();
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.workbench.SystemParametersChangedEvent.__type__, new com.fudanmed.platform.core.web.client.workbench.SystemParametersChangedHandler(){
    public void SystemParametersChanged(){
    	_eventbus_SystemParametersChanged();
    }
    }));
    
  }
}
