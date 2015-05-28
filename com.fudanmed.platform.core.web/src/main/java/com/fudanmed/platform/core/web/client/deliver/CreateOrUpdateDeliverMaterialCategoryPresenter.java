package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialCategoryPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialCategoryPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
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

public class CreateOrUpdateDeliverMaterialCategoryPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateDeliverMaterialCategoryPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateDeliverMaterialCategoryPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateDeliverMaterialCategoryPresenter(final CreateOrUpdateDeliverMaterialCategoryPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final DLDeliverMaterialCategoryProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateDeliverMaterialCategoryPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateDeliverMaterialCategoryPresenterView _view = CreateOrUpdateDeliverMaterialCategoryPresenter.this.getView();
          UIDeliverMaterialCategory _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategorysChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDeliverMaterialCategoryPresenter.this.<Void>onSuccess(_function);
          _service.createValue(parent, _value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateDeliverMaterialCategoryPresenterView _view = CreateOrUpdateDeliverMaterialCategoryPresenter.this.getView();
          _view.setParent(parent);_notifier.done(CreateOrUpdateDeliverMaterialCategoryPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final DLDeliverMaterialCategoryProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateDeliverMaterialCategoryPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateDeliverMaterialCategoryPresenterView _view = CreateOrUpdateDeliverMaterialCategoryPresenter.this.getView();
          UIDeliverMaterialCategory _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategorysChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateDeliverMaterialCategoryPresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDeliverMaterialCategory> _function = new Procedure1<UIDeliverMaterialCategory>() {
              public void apply(final UIDeliverMaterialCategory it) {
                CreateOrUpdateDeliverMaterialCategoryPresenterView _view = CreateOrUpdateDeliverMaterialCategoryPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateDeliverMaterialCategoryPresenter.this);
              }
            };
          AsyncCallback<UIDeliverMaterialCategory> _onSuccess = CreateOrUpdateDeliverMaterialCategoryPresenter.this.<UIDeliverMaterialCategory>onSuccess(_function);
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
