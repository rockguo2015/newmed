package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWorkItemReturnStockRecordProxy;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemReturnStockRecordItemDetailPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemReturnStockRecordItemDetailPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemReturnStockRecord;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStockRecordItem;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemReturnStockRecordItemDetailPresenter extends WorkbenchAbstractPresenter<WorkItemReturnStockRecordItemDetailPresenterView> {
  @Inject
  protected WorkItemReturnStockRecordItemDetailPresenterServiceAsync _service;
  
  @Inject
  public WorkItemReturnStockRecordItemDetailPresenter(final WorkItemReturnStockRecordItemDetailPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCWorkItemReturnStockRecordProxy context;
  
  public void setup(final Procedure1<? super WorkItemReturnStockRecordItemDetailPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(WorkItemReturnStockRecordItemDetailPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCWorkItemReturnStockRecordProxy context, final Procedure1<? super WorkItemReturnStockRecordItemDetailPresenter> postInit) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          WorkItemReturnStockRecordItemDetailPresenter.this.refresh();
          postInit.apply(WorkItemReturnStockRecordItemDetailPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setWorkItemOutStockRecord(final RCWorkItemReturnStockRecordProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIWorkItemStockRecordItem>> _function = new Procedure1<Collection<UIWorkItemStockRecordItem>>() {
          public void apply(final Collection<UIWorkItemStockRecordItem> items) {
            final Procedure1<UIWorkItemReturnStockRecord> _function = new Procedure1<UIWorkItemReturnStockRecord>() {
                public void apply(final UIWorkItemReturnStockRecord value) {
                  
                  getView().setResults(value,items);
                  
                }
              };
            AsyncCallback<UIWorkItemReturnStockRecord> _onSuccess = WorkItemReturnStockRecordItemDetailPresenter.this.<UIWorkItemReturnStockRecord>onSuccess(_function);
            _service.loadValue(WorkItemReturnStockRecordItemDetailPresenter.this.context, _onSuccess);
          }
        };
      AsyncCallback<Collection<UIWorkItemStockRecordItem>> _onSuccess = this.<Collection<UIWorkItemStockRecordItem>>onSuccess(_function);
      _service.loadWorkItemStockRecordItemList(this.context, _onSuccess);
    }
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
