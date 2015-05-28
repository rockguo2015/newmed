package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.CreatePMWorkItemTeamFinishReportPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreatePMWorkItemTeamFinishReportPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemTeamFinishReportData;
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

public class CreatePMWorkItemTeamFinishReportPresenter extends WorkbenchAbstractPresenter<CreatePMWorkItemTeamFinishReportPresenterView> implements CommitablePresenter {
  @Inject
  protected CreatePMWorkItemTeamFinishReportPresenterServiceAsync _service;
  
  @Inject
  public CreatePMWorkItemTeamFinishReportPresenter(final CreatePMWorkItemTeamFinishReportPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCPMWorkItemProxy workitem;
  
  public void setup(final RCPMWorkItemProxy workitem, final IPresenterInitiazerNotifier<CreatePMWorkItemTeamFinishReportPresenter> _notifier) {
    
    this.workitem = workitem;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreatePMWorkItemTeamFinishReportPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    CreatePMWorkItemTeamFinishReportPresenterView _view = this.getView();
    UIPMWorkItemTeamFinishReportData _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent());
          
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.updateValue(this.workitem, _value, _onSuccess);
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
