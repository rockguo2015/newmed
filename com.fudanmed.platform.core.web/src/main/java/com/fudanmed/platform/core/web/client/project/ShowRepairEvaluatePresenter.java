package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.ShowRepairEvaluatePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.ShowRepairEvaluatePresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowRepairEvaluatePresenter extends WorkbenchAbstractPresenter<ShowRepairEvaluatePresenterView> {
  @Inject
  protected ShowRepairEvaluatePresenterServiceAsync _service;
  
  @Inject
  public ShowRepairEvaluatePresenter(final ShowRepairEvaluatePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super ShowRepairEvaluatePresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(ShowRepairEvaluatePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCRepairTaskProxy repairTask, final Procedure1<? super ShowRepairEvaluatePresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIRepairEvaluate> _function = new Procedure1<UIRepairEvaluate>() {
              public void apply(final UIRepairEvaluate it) {
                getView().setValue(it);
                
                postInit.apply(ShowRepairEvaluatePresenter.this);
              }
            };
          AsyncCallback<UIRepairEvaluate> _onSuccess = ShowRepairEvaluatePresenter.this.<UIRepairEvaluate>onSuccess(_function);
          _service.loadEvaluate(repairTask, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setRepairTask(final RCRepairTaskProxy repairTask) {
    
    final Procedure1<UIRepairEvaluate> _function = new Procedure1<UIRepairEvaluate>() {
        public void apply(final UIRepairEvaluate it) {
          getView().setValue(it);
          
        }
      };
    AsyncCallback<UIRepairEvaluate> _onSuccess = this.<UIRepairEvaluate>onSuccess(_function);
    _service.loadEvaluate(repairTask, _onSuccess);
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
