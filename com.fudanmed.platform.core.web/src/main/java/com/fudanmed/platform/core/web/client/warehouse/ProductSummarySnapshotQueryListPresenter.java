package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotQueryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSummarySnapshotStatCriteriaData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ProductSummarySnapshotQueryListPresenter extends WorkbenchAbstractPresenter<ProductSummarySnapshotQueryListPresenterView> {
  @Inject
  protected ProductSummarySnapshotQueryListPresenterServiceAsync _service;
  
  @Inject
  public ProductSummarySnapshotQueryListPresenter(final ProductSummarySnapshotQueryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<ProductSummarySnapshotQueryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          _notifier.done(ProductSummarySnapshotQueryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIProductSummarySnapshotCriteria c) {
    
    final Procedure1<IPagedResult<UIProductSummarySnapshotStatCriteriaData>> _function = new Procedure1<IPagedResult<UIProductSummarySnapshotStatCriteriaData>>() {
        public void apply(final IPagedResult<UIProductSummarySnapshotStatCriteriaData> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIProductSummarySnapshotStatCriteriaData>> _onSuccess = this.<IPagedResult<UIProductSummarySnapshotStatCriteriaData>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIProductSummarySnapshotCriteria>(){
    			
    			public void execute(UIProductSummarySnapshotCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    
  }
}
