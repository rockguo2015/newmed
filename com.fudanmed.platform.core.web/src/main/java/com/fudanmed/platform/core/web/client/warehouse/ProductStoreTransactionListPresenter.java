package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductStorageProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductWarehouseStorageSummaryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductStoreTransaction;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductStoreTransactionListPresenter extends WorkbenchAbstractPresenter<ProductStoreTransactionListPresenterView> {
  @Inject
  protected ProductStoreTransactionListPresenterServiceAsync _service;
  
  @Inject
  public ProductStoreTransactionListPresenter(final ProductStoreTransactionListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super ProductStoreTransactionListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(ProductStoreTransactionListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCProductStorageProxy context, final Procedure1<? super ProductStoreTransactionListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          ProductStoreTransactionListPresenter.this.refresh4Storage(context);
          postInit.apply(ProductStoreTransactionListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setProductStorage(final RCProductStorageProxy context) {
    
    this.refresh4Storage(context);
  }
  
  public void setProductStorage4Summary(final RCProductWarehouseStorageSummaryProxy context) {
    
    this.refresh4Summary(context);
  }
  
  public void setProductStorage4Summary(final RCProductWarehouseStorageSummaryProxy context, final Date dateFrom, final Date dateTo) {
    
    this.refresh4Summary(context, dateFrom, dateTo);
  }
  
  public void refresh4Storage(final RCProductStorageProxy context) {
    
    boolean _notEquals = (!Objects.equal(context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIProductStoreTransaction>> _function = new Procedure1<Collection<UIProductStoreTransaction>>() {
          public void apply(final Collection<UIProductStoreTransaction> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIProductStoreTransaction>> _onSuccess = this.<Collection<UIProductStoreTransaction>>onSuccess(_function);
      _service.loadProductStoreTransactionList(context, _onSuccess);
    }
  }
  
  public void refresh4Summary(final RCProductWarehouseStorageSummaryProxy context) {
    
    boolean _notEquals = (!Objects.equal(context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIProductStoreTransaction>> _function = new Procedure1<Collection<UIProductStoreTransaction>>() {
          public void apply(final Collection<UIProductStoreTransaction> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIProductStoreTransaction>> _onSuccess = this.<Collection<UIProductStoreTransaction>>onSuccess(_function);
      _service.loadProductStoreTransactionList4Summary(context, _onSuccess);
    }
  }
  
  public void refresh4Summary(final RCProductWarehouseStorageSummaryProxy context, final Date dateFrom, final Date dateTo) {
    
    boolean _notEquals = (!Objects.equal(context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIProductStoreTransaction>> _function = new Procedure1<Collection<UIProductStoreTransaction>>() {
          public void apply(final Collection<UIProductStoreTransaction> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIProductStoreTransaction>> _onSuccess = this.<Collection<UIProductStoreTransaction>>onSuccess(_function);
      _service.loadProductStoreTransactionList4Summary(context, dateFrom, dateTo, _onSuccess);
    }
  }
  
  public void reset() {
    
    ArrayList<UIProductStoreTransaction> _newArrayList = CollectionLiterals.<UIProductStoreTransaction>newArrayList();
    getView().setResults(_newArrayList);
    
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
