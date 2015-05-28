package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.ChangePasswdPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.ChangePasswdPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIChangePasswdData;
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

public class ChangePasswdPresenter extends WorkbenchAbstractPresenter<ChangePasswdPresenterView> implements CommitablePresenter {
  @Inject
  protected ChangePasswdPresenterServiceAsync _service;
  
  @Inject
  public ChangePasswdPresenter(final ChangePasswdPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private UserProxy user;
  
  public void setup(final IPresenterInitiazerNotifier<ChangePasswdPresenter> _notifier) {
    
    final Procedure1<UserProxy> _function = new Procedure1<UserProxy>() {
        public void apply(final UserProxy it) {
          ChangePasswdPresenter.this.user = it;
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {_notifier.done(ChangePasswdPresenter.this);
              }
            };
          ChangePasswdPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    AsyncCallback<UserProxy> _onSuccess = this.<UserProxy>onSuccess(_function);
    _service.getCurrentUser(_onSuccess);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    ChangePasswdPresenterView _view = this.getView();
    UIChangePasswdData _value = _view.getValue();
    final Procedure1<UIChangePasswdData> _function = new Procedure1<UIChangePasswdData>() {
        public void apply(final UIChangePasswdData it) {
          it.setUser(ChangePasswdPresenter.this.user);
        }
      };
    final UIChangePasswdData data = ObjectExtensions.<UIChangePasswdData>operator_doubleArrow(_value, _function);
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function_1);
    _service.changePasswd(data, _onSuccess);
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
