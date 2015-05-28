package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCOutStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordItemDetailPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordItemDetailPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIOutStockRecordItem;
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

public class OutStockRecordItemDetailPresenter extends WorkbenchAbstractPresenter<OutStockRecordItemDetailPresenterView> {
  @Inject
  protected OutStockRecordItemDetailPresenterServiceAsync _service;
  
  @Inject
  public OutStockRecordItemDetailPresenter(final OutStockRecordItemDetailPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCOutStockRecordProxy context;
  
  public void setup(final Procedure1<? super OutStockRecordItemDetailPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(OutStockRecordItemDetailPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCOutStockRecordProxy context, final Procedure1<? super OutStockRecordItemDetailPresenter> postInit) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          OutStockRecordItemDetailPresenter.this.refresh();
          postInit.apply(OutStockRecordItemDetailPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setOutStockRecord(final RCOutStockRecordProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIOutStockRecordItem>> _function = new Procedure1<Collection<UIOutStockRecordItem>>() {
          public void apply(final Collection<UIOutStockRecordItem> items) {
            final Procedure1<UIOutStockRecord> _function = new Procedure1<UIOutStockRecord>() {
                public void apply(final UIOutStockRecord value) {
                  
                  getView().setResults(value,items);
                  
                }
              };
            AsyncCallback<UIOutStockRecord> _onSuccess = OutStockRecordItemDetailPresenter.this.<UIOutStockRecord>onSuccess(_function);
            _service.loadValue(OutStockRecordItemDetailPresenter.this.context, _onSuccess);
          }
        };
      AsyncCallback<Collection<UIOutStockRecordItem>> _onSuccess = this.<Collection<UIOutStockRecordItem>>onSuccess(_function);
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
