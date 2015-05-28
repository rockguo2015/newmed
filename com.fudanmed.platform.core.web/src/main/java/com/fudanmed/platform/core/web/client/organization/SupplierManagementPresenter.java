package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateSupplierPresenter;
import com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.SupplierManagementPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.fudanmed.platform.core.web.shared.organization.UISupplierCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SupplierManagementPresenter extends WorkbenchAbstractPresenter<SupplierManagementPresenterView> {
  @Inject
  protected SupplierManagementPresenterServiceAsync _service;
  
  @Inject
  public SupplierManagementPresenter(final SupplierManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateSupplierPresenter> createOrUpdatePresenter;
  
  public void onStartExecution() {
    getView().refresh();
    
  }
  
  public void view_createRequestExecution() {
    
    CreateOrUpdateSupplierPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateSupplierPresenter> _function = new Procedure1<CreateOrUpdateSupplierPresenter>() {
        public void apply(final CreateOrUpdateSupplierPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(new IPresenterInitiazerNotifier<CreateOrUpdateSupplierPresenter>() {
        public void done(CreateOrUpdateSupplierPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void _eventbus_InputNextSupplier() {
    
    CreateOrUpdateSupplierPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateSupplierPresenter> _function = new Procedure1<CreateOrUpdateSupplierPresenter>() {
        public void apply(final CreateOrUpdateSupplierPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(new IPresenterInitiazerNotifier<CreateOrUpdateSupplierPresenter>() {
        public void done(CreateOrUpdateSupplierPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_modifyRequestExecution(final RCSupplierProxy value) {
    
    CreateOrUpdateSupplierPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateSupplierPresenter> _function = new Procedure1<CreateOrUpdateSupplierPresenter>() {
        public void apply(final CreateOrUpdateSupplierPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateSupplierPresenter>() {
        public void done(CreateOrUpdateSupplierPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_deleteRequestExecution(final RCSupplierProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.SuppliersChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void view_filterRequestExecution(final UISupplierCriteria c) {
    
    final Procedure1<IPagedResult<UISupplier>> _function = new Procedure1<IPagedResult<UISupplier>>() {
        public void apply(final IPagedResult<UISupplier> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UISupplier>> _onSuccess = this.<IPagedResult<UISupplier>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_SuppliersChanged() {
    getView().refresh();
    
  }
  
  public void _eventbus_SupplierCreated(final RCSupplierProxy newSupplier) {
    
    getView().refreshNew(newSupplier);
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().createRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_createRequestExecution();
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.InputNextSupplierEvent.__type__, new com.fudanmed.platform.core.web.client.organization.InputNextSupplierHandler(){
    public void InputNextSupplier(){
    	_eventbus_InputNextSupplier();
    }
    }));
    getView().modifyRequest(new RequestHandler1<RCSupplierProxy>(){
    			
    			public void execute(RCSupplierProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCSupplierProxy>(){
    			
    			public void execute(RCSupplierProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UISupplierCriteria>(){
    			
    			public void execute(UISupplierCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.SuppliersChangedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.SuppliersChangedHandler(){
    public void SuppliersChanged(){
    	_eventbus_SuppliersChanged();
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.organization.SupplierCreatedEvent.__type__, new com.fudanmed.platform.core.web.client.organization.SupplierCreatedHandler(){
    public void SupplierCreated(com.fudanmed.platform.core.domain.proxy.RCSupplierProxy newSupplier){
    	_eventbus_SupplierCreated(newSupplier);
    }
    }));
    onStartExecution();
    
  }
}
