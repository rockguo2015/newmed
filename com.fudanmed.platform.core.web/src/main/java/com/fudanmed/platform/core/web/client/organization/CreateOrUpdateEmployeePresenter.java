package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateEmployeePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateEmployeePresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateEmployeePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateEmployeePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateEmployeePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateEmployeePresenter(final CreateOrUpdateEmployeePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCOrganizationProxy org;
  
  public void setup4Create(final RCOrganizationProxy org, final Procedure1<? super CreateOrUpdateEmployeePresenter> postInit) {
    
    this.used4Update = false;
    this.org = org;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateEmployeePresenterView _view = CreateOrUpdateEmployeePresenter.this.getView();
          _view.setOrganization(org);
          postInit.apply(CreateOrUpdateEmployeePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCEmployeeProxy value, final Procedure1<? super CreateOrUpdateEmployeePresenter> postInit) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
              public void apply(final UIEmployee it) {
                CreateOrUpdateEmployeePresenterView _view = CreateOrUpdateEmployeePresenter.this.getView();
                _view.setValue(it);
                postInit.apply(CreateOrUpdateEmployeePresenter.this);
              }
            };
          AsyncCallback<UIEmployee> _onSuccess = CreateOrUpdateEmployeePresenter.this.<UIEmployee>onSuccess(_function);
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
      CreateOrUpdateEmployeePresenterView _view = this.getView();
      UIEmployee _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.EmployeesChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateEmployeePresenterView _view_1 = this.getView();
      UIEmployee _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.EmployeesChangedEvent());
            
            notifier.success();
            CreateOrUpdateEmployeePresenterView _view = CreateOrUpdateEmployeePresenter.this.getView();
            UIEmployee _value = _view.getValue();
            Boolean _inputNext = _value.getInputNext();
            boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_inputNext);
            if (_isLogicTrue) {
              eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.InputNextEmployeeEvent(CreateOrUpdateEmployeePresenter.this.org));
              
            }
          }
        };
      AsyncCallback<Void> _onSuccess_1 = this.<Void>onSuccess(_function_1);
      _service.createValue(this.org, _value_1, _onSuccess_1);
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
