package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.project.WorkItemFinishOutsourcePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.WorkItemFinishOutsourcePresenterView;
import com.fudanmed.platform.core.web.shared.project.WorkItemFinishOutsourceData;
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

public class WorkItemFinishOutsourcePresenter extends WorkbenchAbstractPresenter<WorkItemFinishOutsourcePresenterView> implements CommitablePresenter {
  @Inject
  protected WorkItemFinishOutsourcePresenterServiceAsync _service;
  
  @Inject
  public WorkItemFinishOutsourcePresenter(final WorkItemFinishOutsourcePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCWorkItemTaskProxy context;
  
  public void setup(final RCWorkItemTaskProxy context, final Procedure1<? super WorkItemFinishOutsourcePresenter> postInit) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<String> _function = new Procedure1<String>() {
              public void apply(final String it) {
                getView().setComment(it);
                
                final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
                    public void apply(final Boolean canReport) {
                      if ((canReport).booleanValue()) {getView().canReport();
                        
                      }
                      postInit.apply(WorkItemFinishOutsourcePresenter.this);
                    }
                  };
                AsyncCallback<Boolean> _onSuccess = WorkItemFinishOutsourcePresenter.this.<Boolean>onSuccess(_function);
                _service.canReport(context, _onSuccess);
              }
            };
          AsyncCallback<String> _onSuccess = WorkItemFinishOutsourcePresenter.this.<String>onSuccess(_function);
          _service.loadComment(context, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    WorkItemFinishOutsourcePresenterView _view = this.getView();
    WorkItemFinishOutsourceData _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.WorkItemTasksChangedEvent());
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.GroupTasksChangedEvent());
          
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.commit(this.context, _value, _onSuccess);
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
