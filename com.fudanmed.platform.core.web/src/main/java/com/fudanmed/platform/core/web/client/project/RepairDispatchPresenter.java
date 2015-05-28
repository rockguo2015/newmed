package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairDispatchPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.RepairDispatchPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairDispatchData;
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

public class RepairDispatchPresenter extends WorkbenchAbstractPresenter<RepairDispatchPresenterView> implements CommitablePresenter {
  @Inject
  protected RepairDispatchPresenterServiceAsync _service;
  
  @Inject
  public RepairDispatchPresenter(final RepairDispatchPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCRepairTaskProxy RepairTask;
  
  public void setup(final RCRepairTaskProxy RepairTask, final Procedure1<? super RepairDispatchPresenter> postInit) {
    
    this.RepairTask = RepairTask;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(RepairDispatchPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    RepairDispatchPresenterView _view = this.getView();
    UIRepairDispatchData _repairDispatchData = _view.getRepairDispatchData();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.RepairTasksChangedEvent());
          
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.dispatch(this.RepairTask, _repairDispatchData, _onSuccess);
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
