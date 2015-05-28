package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureDevicePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureDevicePresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
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

public class CreateOrUpdateGasMeasureDevicePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateGasMeasureDevicePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateGasMeasureDevicePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateGasMeasureDevicePresenter(final CreateOrUpdateGasMeasureDevicePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final RCGasMeasureDeviceTypeProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateGasMeasureDevicePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateGasMeasureDevicePresenterView _view = CreateOrUpdateGasMeasureDevicePresenter.this.getView();
          UIGasMeasureDevice _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.GasMeasureDevicesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateGasMeasureDevicePresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, parent, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateGasMeasureDevicePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCGasMeasureDeviceProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateGasMeasureDevicePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateGasMeasureDevicePresenterView _view = CreateOrUpdateGasMeasureDevicePresenter.this.getView();
          UIGasMeasureDevice _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.GasMeasureDevicesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateGasMeasureDevicePresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIGasMeasureDevice> _function = new Procedure1<UIGasMeasureDevice>() {
              public void apply(final UIGasMeasureDevice it) {
                CreateOrUpdateGasMeasureDevicePresenterView _view = CreateOrUpdateGasMeasureDevicePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateGasMeasureDevicePresenter.this);
              }
            };
          AsyncCallback<UIGasMeasureDevice> _onSuccess = CreateOrUpdateGasMeasureDevicePresenter.this.<UIGasMeasureDevice>onSuccess(_function);
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
