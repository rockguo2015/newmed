package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemStockStatisticListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.WorkItemStockStatisticListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemStockStatisticListPresenter extends WorkbenchAbstractPresenter<WorkItemStockStatisticListPresenterView> {
  @Inject
  protected WorkItemStockStatisticListPresenterServiceAsync _service;
  
  @Inject
  public WorkItemStockStatisticListPresenter(final WorkItemStockStatisticListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<WorkItemStockStatisticListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(WorkItemStockStatisticListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void refresh() {
    
    WorkItemStockStatisticListPresenterView _view = this.getView();
    _view.refresh();
  }
  
  public void view_queryRequestExecution(final UIWorkItemStockStatisticsCriteria c) {
    
    final Procedure1<Collection<UIWorkItemStockRecordStatisticsData>> _function = new Procedure1<Collection<UIWorkItemStockRecordStatisticsData>>() {
        public void apply(final Collection<UIWorkItemStockRecordStatisticsData> it) {
          WorkItemStockStatisticListPresenterView _view = WorkItemStockStatisticListPresenter.this.getView();
          _view.setResults(it);
        }
      };
    AsyncCallback<Collection<UIWorkItemStockRecordStatisticsData>> _onSuccess = this.<Collection<UIWorkItemStockRecordStatisticsData>>onSuccess(_function);
    _service.loadRepairTaskList(c, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().queryRequest(new RequestHandler1<UIWorkItemStockStatisticsCriteria>(){
    			
    			public void execute(UIWorkItemStockStatisticsCriteria c){
    				view_queryRequestExecution(c);
    			}
    			
    		});
    
  }
}
