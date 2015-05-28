package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWarehousePresenter;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.WarehouseManagementPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WarehouseManagementPresenter extends WorkbenchAbstractPresenter<WarehouseManagementPresenterView> {
  @Inject
  protected WarehouseManagementPresenterServiceAsync _service;
  
  @Inject
  public WarehouseManagementPresenter(final WarehouseManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateWarehousePresenter> createOrUpdateWarehousePresenter;
  
  public void setup(final Procedure1<? super WarehouseManagementPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          WarehouseManagementPresenter.this.refresh();
          postInit.apply(WarehouseManagementPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void refresh() {
    
    final Procedure1<Collection<UIWarehouse>> _function = new Procedure1<Collection<UIWarehouse>>() {
        public void apply(final Collection<UIWarehouse> items) {
          getView().setResults(items);
          
        }
      };
    AsyncCallback<Collection<UIWarehouse>> _onSuccess = this.<Collection<UIWarehouse>>onSuccess(_function);
    _service.loadWarehouseList(_onSuccess);
  }
  
  public void _eventbus_WarehousesChanged() {
    
    this.refresh();
  }
  
  public void view_createWarehouseRequestExecution() {
    
    CreateOrUpdateWarehousePresenter _get = this.createOrUpdateWarehousePresenter.get();
    final Procedure1<CreateOrUpdateWarehousePresenter> _function = new Procedure1<CreateOrUpdateWarehousePresenter>() {
        public void apply(final CreateOrUpdateWarehousePresenter it) {
          final Procedure1<CreateOrUpdateWarehousePresenter> _function = new Procedure1<CreateOrUpdateWarehousePresenter>() {
              public void apply(final CreateOrUpdateWarehousePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.WarehousesChangedEvent());
                
              }
            };
          it.setup4Create(_function);
        }
      };
    ObjectExtensions.<CreateOrUpdateWarehousePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_updateWarehouseRequestExecution(final RCWarehouseProxy value) {
    
    CreateOrUpdateWarehousePresenter _get = this.createOrUpdateWarehousePresenter.get();
    final Procedure1<CreateOrUpdateWarehousePresenter> _function = new Procedure1<CreateOrUpdateWarehousePresenter>() {
        public void apply(final CreateOrUpdateWarehousePresenter it) {
          final Procedure1<CreateOrUpdateWarehousePresenter> _function = new Procedure1<CreateOrUpdateWarehousePresenter>() {
              public void apply(final CreateOrUpdateWarehousePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.WarehousesChangedEvent());
                
              }
            };
          it.setup4Update(value, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateWarehousePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteWarehouseRequestExecution(final RCWarehouseProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.WarehousesChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.deleteWarehouse(value, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.WarehousesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.WarehousesChangedHandler(){
    public void WarehousesChanged(){
    	_eventbus_WarehousesChanged();
    }
    }));
    getView().createWarehouseRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_createWarehouseRequestExecution();
    			}
    			
    		});
    getView().updateWarehouseRequest(new RequestHandler1<RCWarehouseProxy>(){
    			
    			public void execute(RCWarehouseProxy value){
    				view_updateWarehouseRequestExecution(value);
    			}
    			
    		});
    getView().deleteWarehouseRequest(new RequestHandler1<RCWarehouseProxy>(){
    			
    			public void execute(RCWarehouseProxy value){
    				view_deleteWarehouseRequestExecution(value);
    			}
    			
    		});
    
  }
}
