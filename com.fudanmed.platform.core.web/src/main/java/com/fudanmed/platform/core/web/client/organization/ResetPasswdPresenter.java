package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.ResetPasswdPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.ResetPasswdPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIResetPasswdData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ResetPasswdPresenter extends WorkbenchAbstractPresenter<ResetPasswdPresenterView> implements CommitablePresenter {
  @Inject
  protected ResetPasswdPresenterServiceAsync _service;
  
  @Inject
  public ResetPasswdPresenter(final ResetPasswdPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private UserProxy user;
  
  public void setup(final UserProxy user, final IPresenterInitiazerNotifier<ResetPasswdPresenter> _notifier) {
    
    this.user = user;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<String> _function = new Procedure1<String>() {
              public void apply(final String it) {
                ResetPasswdPresenterView _view = ResetPasswdPresenter.this.getView();
                _view.setDefaultNewPasswd(it);_notifier.done(ResetPasswdPresenter.this);
              }
            };
          AsyncCallback<String> _onSuccess = ResetPasswdPresenter.this.<String>onSuccess(_function);
          _service.getUserId(user, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    ResetPasswdPresenterView _view = this.getView();
    UIResetPasswdData _value = _view.getValue();
    final Procedure1<UIResetPasswdData> _function = new Procedure1<UIResetPasswdData>() {
        public void apply(final UIResetPasswdData it) {
          it.setUser(ResetPasswdPresenter.this.user);
        }
      };
    UIResetPasswdData _doubleArrow = ObjectExtensions.<UIResetPasswdData>operator_doubleArrow(_value, _function);
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function_1);
    _service.changePasswd(_doubleArrow, _onSuccess);
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
