package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckCategoryPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckCategoryPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
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

public class CreateOrUpdateDeliverPatientCheckCategoryPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateDeliverPatientCheckCategoryPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateDeliverPatientCheckCategoryPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateDeliverPatientCheckCategoryPresenter(final CreateOrUpdateDeliverPatientCheckCategoryPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final DLDeliverPatientCheckCategoryProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateDeliverPatientCheckCategoryPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateDeliverPatientCheckCategoryPresenterView _view = CreateOrUpdateDeliverPatientCheckCategoryPresenter.this.getView();
          UIDeliverPatientCheckCategory _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategorysChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDeliverPatientCheckCategoryPresenter.this.<Void>onSuccess(_function);
          _service.createValue(parent, _value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateDeliverPatientCheckCategoryPresenterView _view = CreateOrUpdateDeliverPatientCheckCategoryPresenter.this.getView();
          _view.setParent(parent);_notifier.done(CreateOrUpdateDeliverPatientCheckCategoryPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final DLDeliverPatientCheckCategoryProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateDeliverPatientCheckCategoryPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateDeliverPatientCheckCategoryPresenterView _view = CreateOrUpdateDeliverPatientCheckCategoryPresenter.this.getView();
          UIDeliverPatientCheckCategory _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategorysChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDeliverPatientCheckCategoryPresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDeliverPatientCheckCategory> _function = new Procedure1<UIDeliverPatientCheckCategory>() {
              public void apply(final UIDeliverPatientCheckCategory it) {
                CreateOrUpdateDeliverPatientCheckCategoryPresenterView _view = CreateOrUpdateDeliverPatientCheckCategoryPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateDeliverPatientCheckCategoryPresenter.this);
              }
            };
          AsyncCallback<UIDeliverPatientCheckCategory> _onSuccess = CreateOrUpdateDeliverPatientCheckCategoryPresenter.this.<UIDeliverPatientCheckCategory>onSuccess(_function);
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
