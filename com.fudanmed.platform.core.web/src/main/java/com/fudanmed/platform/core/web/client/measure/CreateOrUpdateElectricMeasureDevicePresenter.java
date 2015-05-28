package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureDevicePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureDevicePresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
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

public class CreateOrUpdateElectricMeasureDevicePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateElectricMeasureDevicePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateElectricMeasureDevicePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateElectricMeasureDevicePresenter(final CreateOrUpdateElectricMeasureDevicePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final RCElectricMeasureDeviceTypeProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateElectricMeasureDevicePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateElectricMeasureDevicePresenterView _view = CreateOrUpdateElectricMeasureDevicePresenter.this.getView();
          UIElectricMeasureDevice _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.ElectricMeasureDevicesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateElectricMeasureDevicePresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, parent, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateElectricMeasureDevicePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCElectricMeasureDeviceProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateElectricMeasureDevicePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateElectricMeasureDevicePresenterView _view = CreateOrUpdateElectricMeasureDevicePresenter.this.getView();
          UIElectricMeasureDevice _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.ElectricMeasureDevicesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateElectricMeasureDevicePresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIElectricMeasureDevice> _function = new Procedure1<UIElectricMeasureDevice>() {
              public void apply(final UIElectricMeasureDevice it) {
                CreateOrUpdateElectricMeasureDevicePresenterView _view = CreateOrUpdateElectricMeasureDevicePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateElectricMeasureDevicePresenter.this);
              }
            };
          AsyncCallback<UIElectricMeasureDevice> _onSuccess = CreateOrUpdateElectricMeasureDevicePresenter.this.<UIElectricMeasureDevice>onSuccess(_function);
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
