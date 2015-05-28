package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.web.client.project.WorkItemTaskListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.WorkItemTaskListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemTaskListPresenter extends WorkbenchAbstractPresenter<WorkItemTaskListPresenterView> {
  @Inject
  protected WorkItemTaskListPresenterServiceAsync _service;
  
  @Inject
  public WorkItemTaskListPresenter(final WorkItemTaskListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCGroupTaskProxy parent;
  
  public void setup(final RCGroupTaskProxy parent, final Procedure1<? super WorkItemTaskListPresenter> postInit) {
    
    this.parent = parent;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIWorkItemTask>> _function = new Procedure1<Collection<UIWorkItemTask>>() {
              public void apply(final Collection<UIWorkItemTask> it) {
                getView().showResults(it);
                
                postInit.apply(WorkItemTaskListPresenter.this);
              }
            };
          AsyncCallback<Collection<UIWorkItemTask>> _onSuccess = WorkItemTaskListPresenter.this.<Collection<UIWorkItemTask>>onSuccess(_function);
          _service.load(parent, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final Procedure1<? super WorkItemTaskListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(WorkItemTaskListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setValue(final RCGroupTaskProxy parent) {
    
    this.parent = parent;
    final Procedure1<Collection<UIWorkItemTask>> _function = new Procedure1<Collection<UIWorkItemTask>>() {
        public void apply(final Collection<UIWorkItemTask> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<Collection<UIWorkItemTask>> _onSuccess = this.<Collection<UIWorkItemTask>>onSuccess(_function);
    _service.load(parent, _onSuccess);
  }
  
  public void _eventbus_WorkItemTasksChanged() {
    
    boolean _notEquals = (!Objects.equal(this.parent, null));
    if (_notEquals) {
      final Procedure1<Collection<UIWorkItemTask>> _function = new Procedure1<Collection<UIWorkItemTask>>() {
          public void apply(final Collection<UIWorkItemTask> it) {
            getView().showResults(it);
            
          }
        };
      AsyncCallback<Collection<UIWorkItemTask>> _onSuccess = this.<Collection<UIWorkItemTask>>onSuccess(_function);
      _service.load(this.parent, _onSuccess);
    }
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.WorkItemTasksChangedEvent.__type__, new com.fudanmed.platform.core.web.client.project.WorkItemTasksChangedHandler(){
    public void WorkItemTasksChanged(){
    	_eventbus_WorkItemTasksChanged();
    }
    }));
    
  }
}
