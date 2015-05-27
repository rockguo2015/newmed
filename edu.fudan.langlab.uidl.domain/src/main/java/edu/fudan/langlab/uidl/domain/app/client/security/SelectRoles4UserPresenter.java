package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import edu.fudan.langlab.uidl.domain.app.client.security.SelectRoles4UserPresenterServiceAsync;
import edu.fudan.langlab.uidl.domain.app.client.security.SelectRoles4UserPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIUserRoles;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SelectRoles4UserPresenter extends WorkbenchAbstractPresenter<SelectRoles4UserPresenterView> implements CommitablePresenter {
  @Inject
  protected SelectRoles4UserPresenterServiceAsync _service;
  
  @Inject
  public SelectRoles4UserPresenter(final SelectRoles4UserPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private UserProxy user;
  
  public void setup(final UserProxy user, final Procedure1<? super SelectRoles4UserPresenter> postInit) {
    
    this.user = user;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<RoleProxy>> _function = new Procedure1<Collection<RoleProxy>>() {
              public void apply(final Collection<RoleProxy> it) {
                getView().setRoles(it);
                
                postInit.apply(SelectRoles4UserPresenter.this);
              }
            };
          AsyncCallback<Collection<RoleProxy>> _onSuccess = SelectRoles4UserPresenter.this.<Collection<RoleProxy>>onSuccess(_function);
          _service.loadRoles4User(user, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    SelectRoles4UserPresenterView _view = this.getView();
    UIUserRoles _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.updateUserRoles(this.user, _value, _onSuccess);
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
