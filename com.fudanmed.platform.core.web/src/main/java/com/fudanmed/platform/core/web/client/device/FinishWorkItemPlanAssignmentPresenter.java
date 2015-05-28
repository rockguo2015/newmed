package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.FinishWorkItemPlanAssignmentPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.FinishWorkItemPlanAssignmentPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignmentFinishData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class FinishWorkItemPlanAssignmentPresenter extends WorkbenchAbstractPresenter<FinishWorkItemPlanAssignmentPresenterView> implements CommitablePresenter {
  @Inject
  protected FinishWorkItemPlanAssignmentPresenterServiceAsync _service;
  
  @Inject
  public FinishWorkItemPlanAssignmentPresenter(final FinishWorkItemPlanAssignmentPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final Iterable<RCWorkItemPlanAssignmentProxy> parent, final IPresenterInitiazerNotifier<FinishWorkItemPlanAssignmentPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          FinishWorkItemPlanAssignmentPresenterView _view = FinishWorkItemPlanAssignmentPresenter.this.getView();
          UIWorkItemPlanAssignmentFinishData _value = _view.getValue();
          List<RCWorkItemPlanAssignmentProxy> _list = IterableExtensions.<RCWorkItemPlanAssignmentProxy>toList(parent);
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentsChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = FinishWorkItemPlanAssignmentPresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, _list, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(FinishWorkItemPlanAssignmentPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    this.commiter.apply(notifier);
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
