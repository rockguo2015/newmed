package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductWarehouseStorageListPresenter extends WorkbenchAbstractPresenter<ProductWarehouseStorageListPresenterView> {
  @Inject
  protected ProductWarehouseStorageListPresenterServiceAsync _service;
  
  @Inject
  public ProductWarehouseStorageListPresenter(final ProductWarehouseStorageListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCProductWarehouseStorageSummaryProxy context;
  
  public void setup(final Procedure1<? super ProductWarehouseStorageListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(ProductWarehouseStorageListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCProductWarehouseStorageSummaryProxy context, final Procedure1<? super ProductWarehouseStorageListPresenter> postInit) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          ProductWarehouseStorageListPresenter.this.refresh();
          postInit.apply(ProductWarehouseStorageListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setProductWarehouseStorageSummary(final RCProductWarehouseStorageSummaryProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIProductWarehouseStorage>> _function = new Procedure1<Collection<UIProductWarehouseStorage>>() {
          public void apply(final Collection<UIProductWarehouseStorage> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIProductWarehouseStorage>> _onSuccess = this.<Collection<UIProductWarehouseStorage>>onSuccess(_function);
      _service.loadProductWarehouseStorageList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_ProductWarehouseStoragesChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStoragesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStoragesChangedHandler(){
    public void ProductWarehouseStoragesChanged(){
    	_eventbus_ProductWarehouseStoragesChanged();
    }
    }));
    
  }
}
