package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureValuePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureValuePresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
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

public class CreateOrUpdateWaterMeasureValuePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateWaterMeasureValuePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateWaterMeasureValuePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateWaterMeasureValuePresenter(final CreateOrUpdateWaterMeasureValuePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final RCMeasureDeviceProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateWaterMeasureValuePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateWaterMeasureValuePresenterView _view = CreateOrUpdateWaterMeasureValuePresenter.this.getView();
          UIWaterMeasureValue _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.MeasureValuesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateWaterMeasureValuePresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, parent, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateWaterMeasureValuePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCWaterMeasureValueProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateWaterMeasureValuePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateWaterMeasureValuePresenterView _view = CreateOrUpdateWaterMeasureValuePresenter.this.getView();
          UIWaterMeasureValue _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.MeasureValuesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateWaterMeasureValuePresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIWaterMeasureValue> _function = new Procedure1<UIWaterMeasureValue>() {
              public void apply(final UIWaterMeasureValue it) {
                CreateOrUpdateWaterMeasureValuePresenterView _view = CreateOrUpdateWaterMeasureValuePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateWaterMeasureValuePresenter.this);
              }
            };
          AsyncCallback<UIWaterMeasureValue> _onSuccess = CreateOrUpdateWaterMeasureValuePresenter.this.<UIWaterMeasureValue>onSuccess(_function);
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
