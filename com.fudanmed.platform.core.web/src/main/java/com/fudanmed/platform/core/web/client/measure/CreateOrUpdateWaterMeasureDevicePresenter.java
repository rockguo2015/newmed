package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureDevicePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureDevicePresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
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

public class CreateOrUpdateWaterMeasureDevicePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateWaterMeasureDevicePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateWaterMeasureDevicePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateWaterMeasureDevicePresenter(final CreateOrUpdateWaterMeasureDevicePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final RCWaterMeasureDeviceTypeProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateWaterMeasureDevicePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateWaterMeasureDevicePresenterView _view = CreateOrUpdateWaterMeasureDevicePresenter.this.getView();
          UIWaterMeasureDevice _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.WaterMeasureDevicesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateWaterMeasureDevicePresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, parent, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateWaterMeasureDevicePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCWaterMeasureDeviceProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateWaterMeasureDevicePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateWaterMeasureDevicePresenterView _view = CreateOrUpdateWaterMeasureDevicePresenter.this.getView();
          UIWaterMeasureDevice _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.WaterMeasureDevicesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateWaterMeasureDevicePresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIWaterMeasureDevice> _function = new Procedure1<UIWaterMeasureDevice>() {
              public void apply(final UIWaterMeasureDevice it) {
                CreateOrUpdateWaterMeasureDevicePresenterView _view = CreateOrUpdateWaterMeasureDevicePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateWaterMeasureDevicePresenter.this);
              }
            };
          AsyncCallback<UIWaterMeasureDevice> _onSuccess = CreateOrUpdateWaterMeasureDevicePresenter.this.<UIWaterMeasureDevice>onSuccess(_function);
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
