package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.TaskQueryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.TaskQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UITask;
import com.fudanmed.platform.core.web.shared.deliver.UITaskCriteria;
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

public class TaskQueryListPresenter extends WorkbenchAbstractPresenter<TaskQueryListPresenterView> {
  @Inject
  protected TaskQueryListPresenterServiceAsync _service;
  
  @Inject
  public TaskQueryListPresenter(final TaskQueryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<TaskQueryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          _notifier.done(TaskQueryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UITaskCriteria c) {
    
    final Procedure1<IPagedResult<UITask>> _function = new Procedure1<IPagedResult<UITask>>() {
        public void apply(final IPagedResult<UITask> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UITask>> _onSuccess = this.<IPagedResult<UITask>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UITaskCriteria>(){
    			
    			public void execute(UITaskCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    
  }
}
