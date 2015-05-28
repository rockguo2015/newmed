package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairTaskDetailInfoPresenter extends WorkbenchAbstractPresenter<RepairTaskDetailInfoPresenterView> {
  @Inject
  protected RepairTaskDetailInfoPresenterServiceAsync _service;
  
  @Inject
  public RepairTaskDetailInfoPresenter(final RepairTaskDetailInfoPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super RepairTaskDetailInfoPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(RepairTaskDetailInfoPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setRepairTask(final RCRepairTaskProxy repairTask) {
    
    final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
        public void apply(final UIRepairTask it) {
          getView().setValue(it);
          
        }
      };
    AsyncCallback<UIRepairTask> _onSuccess = this.<UIRepairTask>onSuccess(_function);
    _service.loadRepairTask(repairTask, _onSuccess);
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
