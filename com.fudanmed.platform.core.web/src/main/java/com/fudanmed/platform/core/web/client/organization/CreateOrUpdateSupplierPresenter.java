package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateSupplierPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateSupplierPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UISupplier;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateSupplierPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateSupplierPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateSupplierPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateSupplierPresenter(final CreateOrUpdateSupplierPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super Procedure1<? super Void>> commiter;
  
  public void setup4Create(final IPresenterInitiazerNotifier<CreateOrUpdateSupplierPresenter> _notifier) {
    
    final Procedure1<Procedure1<? super Void>> _function = new Procedure1<Procedure1<? super Void>>() {
        public void apply(final Procedure1<? super Void> notifier) {
          CreateOrUpdateSupplierPresenterView _view = CreateOrUpdateSupplierPresenter.this.getView();
          UISupplier _value = _view.getValue();
          final Procedure1<RCSupplierProxy> _function = new Procedure1<RCSupplierProxy>() {
              public void apply(final RCSupplierProxy it) {
                eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.SupplierCreatedEvent(it));
                
                notifier.apply(null);
                CreateOrUpdateSupplierPresenterView _view = CreateOrUpdateSupplierPresenter.this.getView();
                UISupplier _value = _view.getValue();
                Boolean _inputNext = _value.getInputNext();
                boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_inputNext);
                if (_isLogicTrue) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.InputNextSupplierEvent());
                  
                }
              }
            };
          AsyncCallback<RCSupplierProxy> _onSuccess = CreateOrUpdateSupplierPresenter.this.<RCSupplierProxy>onSuccess(_function);
          _service.createValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateSupplierPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCSupplierProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateSupplierPresenter> _notifier) {
    
    final Procedure1<Procedure1<? super Void>> _function = new Procedure1<Procedure1<? super Void>>() {
        public void apply(final Procedure1<? super Void> notifier) {
          CreateOrUpdateSupplierPresenterView _view = CreateOrUpdateSupplierPresenter.this.getView();
          UISupplier _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.SuppliersChangedEvent());
                
                notifier.apply(null);
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateSupplierPresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UISupplier> _function = new Procedure1<UISupplier>() {
              public void apply(final UISupplier it) {
                CreateOrUpdateSupplierPresenterView _view = CreateOrUpdateSupplierPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateSupplierPresenter.this);
              }
            };
          AsyncCallback<UISupplier> _onSuccess = CreateOrUpdateSupplierPresenter.this.<UISupplier>onSuccess(_function);
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
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          notifier.success();
        }
      };
    this.commiter.apply(_function);
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
