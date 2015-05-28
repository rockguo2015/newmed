package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterView;
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

public class CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter extends WorkbenchAbstractPresenter<CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter(final CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup4Update(final RCPMWorkItemWorkerAssignmentProxy value, final IPresenterInitiazerNotifier<CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIPMWorkItemWorkerAssignment> _function = new Procedure1<UIPMWorkItemWorkerAssignment>() {
              public void apply(final UIPMWorkItemWorkerAssignment it) {
                CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterView _view = CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter.this.getView();
                _view.setValue(it);
                final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
                    public void apply(final Boolean allFinished) {
                      CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterView _view = CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter.this.getView();
                      _view.setCanFinish(allFinished);_notifier.done(CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter.this);
                    }
                  };
                AsyncCallback<Boolean> _onSuccess = CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter.this.<Boolean>onSuccess(_function);
                _service.allWorkFinishedExceptThis(value, _onSuccess);
              }
            };
          AsyncCallback<UIPMWorkItemWorkerAssignment> _onSuccess = CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter.this.<UIPMWorkItemWorkerAssignment>onSuccess(_function);
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
    
    CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenterView _view = this.getView();
    UIPMWorkItemWorkerAssignment _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent());
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentsChangedEvent());
          
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
