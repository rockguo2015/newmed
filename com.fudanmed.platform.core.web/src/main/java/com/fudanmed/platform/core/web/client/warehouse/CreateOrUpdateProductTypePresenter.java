package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductTypePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductTypePresenterView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateProductTypePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateProductTypePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateProductTypePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateProductTypePresenter(final CreateOrUpdateProductTypePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCProductCategoryProxy parent;
  
  public void setup4Create(final RCProductCategoryProxy parent, final Procedure1<? super CreateOrUpdateProductTypePresenter> postInitializer) {
    
    this.used4Update = false;
    this.parent = parent;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          getView().setParent(parent);
          
          postInitializer.apply(CreateOrUpdateProductTypePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCProductTypeProxy value, final Procedure1<? super CreateOrUpdateProductTypePresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIProductType> _function = new Procedure1<UIProductType>() {
              public void apply(final UIProductType it) {
                CreateOrUpdateProductTypePresenterView _view = CreateOrUpdateProductTypePresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateProductTypePresenter.this);
              }
            };
          AsyncCallback<UIProductType> _onSuccess = CreateOrUpdateProductTypePresenter.this.<UIProductType>onSuccess(_function);
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
      CreateOrUpdateProductTypePresenterView _view = this.getView();
      UIProductType _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductTypesChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateProductTypePresenterView _view_1 = this.getView();
      UIProductType _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.warehouse.ProductTypesChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess_1 = this.<Void>onSuccess(_function_1);
      _service.createValue(this.parent, _value_1, _onSuccess_1);
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
