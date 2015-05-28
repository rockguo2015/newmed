package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypePresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.google.common.base.Objects;
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

public class CreateOrUpdateDeviceTypePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateDeviceTypePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateDeviceTypePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateDeviceTypePresenter(final CreateOrUpdateDeviceTypePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCDeviceTypeProxy cloneSource;
  
  private RCDeviceTypeCategoryProxy typeCategory;
  
  public void setup4Create(final RCDeviceTypeCategoryProxy typeCategory, final IPresenterInitiazerNotifier<CreateOrUpdateDeviceTypePresenter> _notifier) {
    
    this.typeCategory = typeCategory;
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          CreateOrUpdateDeviceTypePresenterView _view = CreateOrUpdateDeviceTypePresenter.this.getView();
          _view.setCategory(typeCategory);_notifier.done(CreateOrUpdateDeviceTypePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCDeviceTypeProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateDeviceTypePresenter> _notifier) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIDeviceType> _function = new Procedure1<UIDeviceType>() {
              public void apply(final UIDeviceType it) {
                CreateOrUpdateDeviceTypePresenterView _view = CreateOrUpdateDeviceTypePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateDeviceTypePresenter.this);
              }
            };
          AsyncCallback<UIDeviceType> _onSuccess = CreateOrUpdateDeviceTypePresenter.this.<UIDeviceType>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Clone(final RCDeviceTypeProxy cloneSource, final IPresenterInitiazerNotifier<CreateOrUpdateDeviceTypePresenter> _notifier) {
    
    this.cloneSource = cloneSource;
    final Procedure1<RCDeviceTypeCategoryProxy> _function = new Procedure1<RCDeviceTypeCategoryProxy>() {
        public void apply(final RCDeviceTypeCategoryProxy typeCategory) {
          CreateOrUpdateDeviceTypePresenter.this.typeCategory = typeCategory;
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                CreateOrUpdateDeviceTypePresenterView _view = CreateOrUpdateDeviceTypePresenter.this.getView();
                _view.setCategory(typeCategory);_notifier.done(CreateOrUpdateDeviceTypePresenter.this);
              }
            };
          CreateOrUpdateDeviceTypePresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    AsyncCallback<RCDeviceTypeCategoryProxy> _onSuccess = this.<RCDeviceTypeCategoryProxy>onSuccess(_function);
    _service.loadCategory(cloneSource, _onSuccess);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdateDeviceTypePresenterView _view = this.getView();
      UIDeviceType _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DeviceTypesChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      boolean _equals = Objects.equal(this.cloneSource, null);
      if (_equals) {
        CreateOrUpdateDeviceTypePresenterView _view_1 = this.getView();
        UIDeviceType _value_1 = _view_1.getValue();
        final Procedure1<Void> _function_1 = new Procedure1<Void>() {
            public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DeviceTypesChangedEvent());
              
              notifier.success();
            }
          };
        AsyncCallback<Void> _onSuccess_1 = this.<Void>onSuccess(_function_1);
        _service.createValue(this.typeCategory, _value_1, _onSuccess_1);
      } else {
        CreateOrUpdateDeviceTypePresenterView _view_2 = this.getView();
        UIDeviceType _value_2 = _view_2.getValue();
        final Procedure1<Void> _function_2 = new Procedure1<Void>() {
            public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.DeviceTypesChangedEvent());
              
              notifier.success();
            }
          };
        AsyncCallback<Void> _onSuccess_2 = this.<Void>onSuccess(_function_2);
        _service.createValueWithClone(this.typeCategory, this.cloneSource, _value_2, _onSuccess_2);
      }
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
