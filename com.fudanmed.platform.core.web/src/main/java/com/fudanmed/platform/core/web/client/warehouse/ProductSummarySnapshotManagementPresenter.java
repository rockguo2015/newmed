package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotManagementPresenterView;
import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotQueryListPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductSummarySnapshotManagementPresenter extends WorkbenchAbstractPresenter<ProductSummarySnapshotManagementPresenterView> {
  @Inject
  public ProductSummarySnapshotManagementPresenter(final ProductSummarySnapshotManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public ProductSummarySnapshotQueryListPresenter initPart(final ProductSummarySnapshotQueryListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private ProductSummarySnapshotQueryListPresenter queryListPresenter;
  
  public ProductStoreTransactionListPresenter initPart(final ProductStoreTransactionListPresenter part) {
    this.registerPart(part);
    this.getView().setProductStoreTransactionListPresenter(part);
    return part;
    
  }
  
  @Inject
  private ProductStoreTransactionListPresenter productStoreTransactionListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<ProductSummarySnapshotManagementPresenter> _notifier) {
    
    ProductSummarySnapshotQueryListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<ProductSummarySnapshotQueryListPresenter> _function = new Procedure1<ProductSummarySnapshotQueryListPresenter>() {
        public void apply(final ProductSummarySnapshotQueryListPresenter it) {
          ProductStoreTransactionListPresenter _initPart = ProductSummarySnapshotManagementPresenter.this.initPart(ProductSummarySnapshotManagementPresenter.this.productStoreTransactionListPresenter);
          final Procedure1<ProductStoreTransactionListPresenter> _function = new Procedure1<ProductStoreTransactionListPresenter>() {
              public void apply(final ProductStoreTransactionListPresenter it) {
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {_notifier.done(ProductSummarySnapshotManagementPresenter.this);
                    }
                  };
                ProductSummarySnapshotManagementPresenter.this.activate(new IPostInitializeAction() {
                    public void initializeFinished(Void v) {
                      _function.apply(v);
                    }
                });
              }
            };
          _initPart.setup(_function);
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<ProductSummarySnapshotQueryListPresenter>() {
        public void done(ProductSummarySnapshotQueryListPresenter presenter) {
          _function.apply(presenter);
        }
    });
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
