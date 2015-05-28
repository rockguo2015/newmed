package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingListProxy;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingInputQuantityPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingInputQuantityPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class StockTakingInputQuantityPresenter extends WorkbenchAbstractPresenter<StockTakingInputQuantityPresenterView> implements CommitablePresenter {
  @Inject
  protected StockTakingInputQuantityPresenterServiceAsync _service;
  
  @Inject
  public StockTakingInputQuantityPresenter(final StockTakingInputQuantityPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final RCStockTakingListProxy takingList, final Procedure1<? super StockTakingInputQuantityPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIStockTakingItem>> _function = new Procedure1<Collection<UIStockTakingItem>>() {
              public void apply(final Collection<UIStockTakingItem> it) {
                getView().setItems(it);
                
                postInit.apply(StockTakingInputQuantityPresenter.this);
              }
            };
          AsyncCallback<Collection<UIStockTakingItem>> _onSuccess = StockTakingInputQuantityPresenter.this.<Collection<UIStockTakingItem>>onSuccess(_function);
          _service.loadItems(takingList, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    StockTakingInputQuantityPresenterView _view = this.getView();
    Collection<UIStockTakingItem> _items = _view.getItems();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.StockTakingListsChangedEvent());
          
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.updateItems(_items, _onSuccess);
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
