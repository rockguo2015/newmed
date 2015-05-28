package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemOutStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordItemDetailPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemOutStockRecordItemDetailPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemOutStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
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

public class WorkItemOutStockRecordItemDetailPresenter extends WorkbenchAbstractPresenter<WorkItemOutStockRecordItemDetailPresenterView> {
  @Inject
  protected WorkItemOutStockRecordItemDetailPresenterServiceAsync _service;
  
  @Inject
  public WorkItemOutStockRecordItemDetailPresenter(final WorkItemOutStockRecordItemDetailPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCWorkItemOutStockRecordProxy context;
  
  public void setup(final Procedure1<? super WorkItemOutStockRecordItemDetailPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(WorkItemOutStockRecordItemDetailPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCWorkItemOutStockRecordProxy context, final Procedure1<? super WorkItemOutStockRecordItemDetailPresenter> postInit) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          WorkItemOutStockRecordItemDetailPresenter.this.refresh();
          postInit.apply(WorkItemOutStockRecordItemDetailPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setWorkItemOutStockRecord(final RCWorkItemOutStockRecordProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIWorkItemStockRecordItem>> _function = new Procedure1<Collection<UIWorkItemStockRecordItem>>() {
          public void apply(final Collection<UIWorkItemStockRecordItem> items) {
            final Procedure1<UIWorkItemOutStockRecord> _function = new Procedure1<UIWorkItemOutStockRecord>() {
                public void apply(final UIWorkItemOutStockRecord value) {
                  
                  getView().setResults(value,items);
                  
                }
              };
            AsyncCallback<UIWorkItemOutStockRecord> _onSuccess = WorkItemOutStockRecordItemDetailPresenter.this.<UIWorkItemOutStockRecord>onSuccess(_function);
            _service.loadValue(WorkItemOutStockRecordItemDetailPresenter.this.context, _onSuccess);
          }
        };
      AsyncCallback<Collection<UIWorkItemStockRecordItem>> _onSuccess = this.<Collection<UIWorkItemStockRecordItem>>onSuccess(_function);
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
