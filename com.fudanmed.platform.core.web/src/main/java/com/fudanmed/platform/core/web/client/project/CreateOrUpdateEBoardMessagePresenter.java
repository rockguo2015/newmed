package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateEBoardMessagePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateEBoardMessagePresenterView;
import com.fudanmed.platform.core.web.shared.project.UIEBoardMessage;
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

public class CreateOrUpdateEBoardMessagePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateEBoardMessagePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateEBoardMessagePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateEBoardMessagePresenter(final CreateOrUpdateEBoardMessagePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Update(final RCEBoardMessageProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateEBoardMessagePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateEBoardMessagePresenterView _view = CreateOrUpdateEBoardMessagePresenter.this.getView();
          UIEBoardMessage _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateEBoardMessagePresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIEBoardMessage> _function = new Procedure1<UIEBoardMessage>() {
              public void apply(final UIEBoardMessage it) {
                CreateOrUpdateEBoardMessagePresenterView _view = CreateOrUpdateEBoardMessagePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateEBoardMessagePresenter.this);
              }
            };
          AsyncCallback<UIEBoardMessage> _onSuccess = CreateOrUpdateEBoardMessagePresenter.this.<UIEBoardMessage>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
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
