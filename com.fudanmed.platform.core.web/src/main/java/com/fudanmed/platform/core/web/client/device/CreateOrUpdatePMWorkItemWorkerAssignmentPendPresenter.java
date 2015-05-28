package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter extends WorkbenchAbstractPresenter<CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter(final CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup4Update(final RCPMWorkItemWorkerAssignmentProxy value, final IPresenterInitiazerNotifier<CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIPMWorkItemWorkerAssignment> _function = new Procedure1<UIPMWorkItemWorkerAssignment>() {
              public void apply(final UIPMWorkItemWorkerAssignment it) {
                CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterView _view = CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter.this);
              }
            };
          AsyncCallback<UIPMWorkItemWorkerAssignment> _onSuccess = CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter.this.<UIPMWorkItemWorkerAssignment>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenterView _view = this.getView();
    UIPMWorkItemWorkerAssignment _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentsChangedEvent());
          
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.updateValue(_value, _onSuccess);
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
