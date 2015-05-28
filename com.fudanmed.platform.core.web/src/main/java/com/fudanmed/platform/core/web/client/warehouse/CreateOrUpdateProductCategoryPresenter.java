package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductCategoryPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductCategoryPresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateProductCategoryPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateProductCategoryPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateProductCategoryPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateProductCategoryPresenter(final CreateOrUpdateProductCategoryPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCProductCategoryProxy parent;
  
  public void setup4Create(final RCProductCategoryProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateProductCategoryPresenter> _notifier) {
    
    this.used4Update = false;
    this.parent = parent;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          getView().setParent(parent);
          _notifier.done(CreateOrUpdateProductCategoryPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCProductCategoryProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateProductCategoryPresenter> _notifier) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIProductCategory> _function = new Procedure1<UIProductCategory>() {
              public void apply(final UIProductCategory it) {
                CreateOrUpdateProductCategoryPresenterView _view = CreateOrUpdateProductCategoryPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateProductCategoryPresenter.this);
              }
            };
          AsyncCallback<UIProductCategory> _onSuccess = CreateOrUpdateProductCategoryPresenter.this.<UIProductCategory>onSuccess(_function);
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
      CreateOrUpdateProductCategoryPresenterView _view = this.getView();
      UIProductCategory _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {
            CreateOrUpdateProductCategoryPresenterView _view = CreateOrUpdateProductCategoryPresenter.this.getView();
            UIProductCategory _value = _view.getValue();
            RCProductCategoryProxy _proxy = _value.toProxy();
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductCategoryChangedEvent(_proxy));
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateProductCategoryPresenterView _view_1 = this.getView();
      UIProductCategory _value_1 = _view_1.getValue();
      final Procedure1<UIProductCategory> _function_1 = new Procedure1<UIProductCategory>() {
          public void apply(final UIProductCategory it) {
            it.setParent(CreateOrUpdateProductCategoryPresenter.this.parent);
          }
        };
      UIProductCategory _doubleArrow = ObjectExtensions.<UIProductCategory>operator_doubleArrow(_value_1, _function_1);
      final Procedure1<RCProductCategoryProxy> _function_2 = new Procedure1<RCProductCategoryProxy>() {
          public void apply(final RCProductCategoryProxy it) {
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductCategoryAddedEvent(it));
            
            notifier.success();
          }
        };
      AsyncCallback<RCProductCategoryProxy> _onSuccess_1 = this.<RCProductCategoryProxy>onSuccess(_function_2);
      _service.createValue(_doubleArrow, _onSuccess_1);
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
