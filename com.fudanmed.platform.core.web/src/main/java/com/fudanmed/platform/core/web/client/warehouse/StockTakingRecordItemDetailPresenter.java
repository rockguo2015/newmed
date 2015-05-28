package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCStockTakingRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordItemDetailPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordItemDetailPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingRecordItem;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class StockTakingRecordItemDetailPresenter extends WorkbenchAbstractPresenter<StockTakingRecordItemDetailPresenterView> {
  @Inject
  protected StockTakingRecordItemDetailPresenterServiceAsync _service;
  
  @Inject
  public StockTakingRecordItemDetailPresenter(final StockTakingRecordItemDetailPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCStockTakingRecordProxy context;
  
  public void setup(final Procedure1<? super StockTakingRecordItemDetailPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(StockTakingRecordItemDetailPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCStockTakingRecordProxy context, final Procedure1<? super StockTakingRecordItemDetailPresenter> postInit) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          StockTakingRecordItemDetailPresenter.this.refresh();
          postInit.apply(StockTakingRecordItemDetailPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setStockTakingRecord(final RCStockTakingRecordProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIStockTakingRecordItem>> _function = new Procedure1<Collection<UIStockTakingRecordItem>>() {
          public void apply(final Collection<UIStockTakingRecordItem> items) {
            final Procedure1<UIStockTakingRecord> _function = new Procedure1<UIStockTakingRecord>() {
                public void apply(final UIStockTakingRecord value) {
                  
                  getView().setResults(value,items);
                  
                }
              };
            AsyncCallback<UIStockTakingRecord> _onSuccess = StockTakingRecordItemDetailPresenter.this.<UIStockTakingRecord>onSuccess(_function);
            _service.loadValue(StockTakingRecordItemDetailPresenter.this.context, _onSuccess);
          }
        };
      AsyncCallback<Collection<UIStockTakingRecordItem>> _onSuccess = this.<Collection<UIStockTakingRecordItem>>onSuccess(_function);
      _service.loadWorkItemStockRecordItemList(this.context, _onSuccess);
    }
  }
  
  public void view_printExecution() {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String html) {
          Print.it(html);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.generatePrintContents(this.context, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().print(new RequestHandler(){
    			
    			public void execute(){
    				view_printExecution();
    			}
    			
    		});
    
  }
}
