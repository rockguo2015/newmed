package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import edu.fudan.langlab.domain.security.proxy.RoleProxy;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateRolePresenterServiceAsync;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateRolePresenterView;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIRole;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateRolePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateRolePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateRolePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateRolePresenter(final CreateOrUpdateRolePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final Procedure1<? super CreateOrUpdateRolePresenter> postInitializer) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInitializer.apply(CreateOrUpdateRolePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RoleProxy value, final Procedure1<? super CreateOrUpdateRolePresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIRole> _function = new Procedure1<UIRole>() {
              public void apply(final UIRole it) {
                CreateOrUpdateRolePresenterView _view = CreateOrUpdateRolePresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateRolePresenter.this);
              }
            };
          AsyncCallback<UIRole> _onSuccess = CreateOrUpdateRolePresenter.this.<UIRole>onSuccess(_function);
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
    
    if (this.used4Update) {
      CreateOrUpdateRolePresenterView _view = this.getView();
      UIRole _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.security.RolesChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateRolePresenterView _view_1 = this.getView();
      UIRole _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.security.RolesChangedEvent());
            
            notifier.success();
            CreateOrUpdateRolePresenterView _view = CreateOrUpdateRolePresenter.this.getView();
            UIRole _value = _view.getValue();
            Boolean _inputNext = _value.getInputNext();
            boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_inputNext);
            if (_isLogicTrue) {eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.security.InputNextRoleEvent());
              
            }
          }
        };
      AsyncCallback<Void> _onSuccess_1 = this.<Void>onSuccess(_function_1);
      _service.createValue(_value_1, _onSuccess_1);
    }
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
