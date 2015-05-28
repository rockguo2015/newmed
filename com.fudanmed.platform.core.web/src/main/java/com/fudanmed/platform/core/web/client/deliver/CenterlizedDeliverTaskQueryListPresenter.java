package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskQueryListPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.selector.IHasObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CenterlizedDeliverTaskQueryListPresenter extends WorkbenchAbstractPresenter<CenterlizedDeliverTaskQueryListPresenterView> implements IHasObjectSelectionProvider<UICenterlizedDeliverTask> {
  @Inject
  protected CenterlizedDeliverTaskQueryListPresenterServiceAsync _service;
  
  @Inject
  public CenterlizedDeliverTaskQueryListPresenter(final CenterlizedDeliverTaskQueryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<CenterlizedDeliverTaskQueryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          _notifier.done(CenterlizedDeliverTaskQueryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_filterRequestExecution(final UICenterlizedDeliverTaskCriteria c) {
    
    final Procedure1<IPagedResult<UICenterlizedDeliverTask>> _function = new Procedure1<IPagedResult<UICenterlizedDeliverTask>>() {
        public void apply(final IPagedResult<UICenterlizedDeliverTask> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UICenterlizedDeliverTask>> _onSuccess = this.<IPagedResult<UICenterlizedDeliverTask>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_CenterlizedDeliverTasksChanged() {
    getView().refresh();
    
  }
  
  public ObjectSelectionProvider<UICenterlizedDeliverTask> getSelectionProvider() {
    
    CenterlizedDeliverTaskQueryListPresenterView _view = this.getView();
    ActionContext<UICenterlizedDeliverTask> _actionContext = _view.getActionContext();
    return _actionContext;
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UICenterlizedDeliverTaskCriteria>(){
    			
    			public void execute(UICenterlizedDeliverTaskCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTasksChangedEvent.__type__, new com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTasksChangedHandler(){
    public void CenterlizedDeliverTasksChanged(){
    	_eventbus_CenterlizedDeliverTasksChanged();
    }
    }));
    
  }
}
