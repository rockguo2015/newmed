package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureDevicePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureDevicePresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
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

public class CreateOrUpdatePhasedElectricMeasureDevicePresenter extends WorkbenchAbstractPresenter<CreateOrUpdatePhasedElectricMeasureDevicePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdatePhasedElectricMeasureDevicePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdatePhasedElectricMeasureDevicePresenter(final CreateOrUpdatePhasedElectricMeasureDevicePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final RCPhasedElectricMeasureDeviceTypeProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdatePhasedElectricMeasureDevicePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdatePhasedElectricMeasureDevicePresenterView _view = CreateOrUpdatePhasedElectricMeasureDevicePresenter.this.getView();
          UIPhasedElectricMeasureDevice _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDevicesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdatePhasedElectricMeasureDevicePresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, parent, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdatePhasedElectricMeasureDevicePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCPhasedElectricMeasureDeviceProxy value, final IPresenterInitiazerNotifier<CreateOrUpdatePhasedElectricMeasureDevicePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdatePhasedElectricMeasureDevicePresenterView _view = CreateOrUpdatePhasedElectricMeasureDevicePresenter.this.getView();
          UIPhasedElectricMeasureDevice _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDevicesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdatePhasedElectricMeasureDevicePresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIPhasedElectricMeasureDevice> _function = new Procedure1<UIPhasedElectricMeasureDevice>() {
              public void apply(final UIPhasedElectricMeasureDevice it) {
                CreateOrUpdatePhasedElectricMeasureDevicePresenterView _view = CreateOrUpdatePhasedElectricMeasureDevicePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdatePhasedElectricMeasureDevicePresenter.this);
              }
            };
          AsyncCallback<UIPhasedElectricMeasureDevice> _onSuccess = CreateOrUpdatePhasedElectricMeasureDevicePresenter.this.<UIPhasedElectricMeasureDevice>onSuccess(_function);
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
