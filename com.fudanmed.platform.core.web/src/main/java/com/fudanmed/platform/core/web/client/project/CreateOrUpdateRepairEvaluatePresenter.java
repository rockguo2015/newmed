package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairEvaluatePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairEvaluatePresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
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

public class CreateOrUpdateRepairEvaluatePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateRepairEvaluatePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateRepairEvaluatePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateRepairEvaluatePresenter(final CreateOrUpdateRepairEvaluatePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup4Update(final RCRepairEvaluateProxy value, final Procedure1<? super CreateOrUpdateRepairEvaluatePresenter> postInitializer) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIRepairEvaluate> _function = new Procedure1<UIRepairEvaluate>() {
              public void apply(final UIRepairEvaluate it) {
                CreateOrUpdateRepairEvaluatePresenterView _view = CreateOrUpdateRepairEvaluatePresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateRepairEvaluatePresenter.this);
              }
            };
          AsyncCallback<UIRepairEvaluate> _onSuccess = CreateOrUpdateRepairEvaluatePresenter.this.<UIRepairEvaluate>onSuccess(_function);
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
    
    CreateOrUpdateRepairEvaluatePresenterView _view = this.getView();
    UIRepairEvaluate _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.RepairEvaluatesChangedEvent());
          
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
