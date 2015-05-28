package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckTypePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckTypePresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
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

public class CreateOrUpdateDeliverPatientCheckTypePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateDeliverPatientCheckTypePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateDeliverPatientCheckTypePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateDeliverPatientCheckTypePresenter(final CreateOrUpdateDeliverPatientCheckTypePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final DLDeliverPatientCheckCategoryProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateDeliverPatientCheckTypePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateDeliverPatientCheckTypePresenterView _view = CreateOrUpdateDeliverPatientCheckTypePresenter.this.getView();
          UIDeliverPatientCheckType _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDeliverPatientCheckTypePresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, parent, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateDeliverPatientCheckTypePresenterView _view = CreateOrUpdateDeliverPatientCheckTypePresenter.this.getView();
          _view.setCategory(parent);_notifier.done(CreateOrUpdateDeliverPatientCheckTypePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final DLDeliverPatientCheckTypeProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateDeliverPatientCheckTypePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateDeliverPatientCheckTypePresenterView _view = CreateOrUpdateDeliverPatientCheckTypePresenter.this.getView();
          UIDeliverPatientCheckType _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDeliverPatientCheckTypePresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDeliverPatientCheckType> _function = new Procedure1<UIDeliverPatientCheckType>() {
              public void apply(final UIDeliverPatientCheckType it) {
                CreateOrUpdateDeliverPatientCheckTypePresenterView _view = CreateOrUpdateDeliverPatientCheckTypePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateDeliverPatientCheckTypePresenter.this);
              }
            };
          AsyncCallback<UIDeliverPatientCheckType> _onSuccess = CreateOrUpdateDeliverPatientCheckTypePresenter.this.<UIDeliverPatientCheckType>onSuccess(_function);
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
