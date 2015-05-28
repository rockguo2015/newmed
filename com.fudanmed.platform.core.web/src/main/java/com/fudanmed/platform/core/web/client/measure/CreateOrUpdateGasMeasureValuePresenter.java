package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureValueProxy;
import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureValuePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureValuePresenterView;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureValue;
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

public class CreateOrUpdateGasMeasureValuePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateGasMeasureValuePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateGasMeasureValuePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateGasMeasureValuePresenter(final CreateOrUpdateGasMeasureValuePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final RCMeasureDeviceProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdateGasMeasureValuePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateGasMeasureValuePresenterView _view = CreateOrUpdateGasMeasureValuePresenter.this.getView();
          UIGasMeasureValue _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.MeasureValuesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateGasMeasureValuePresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, parent, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateGasMeasureValuePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCGasMeasureValueProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateGasMeasureValuePresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateGasMeasureValuePresenterView _view = CreateOrUpdateGasMeasureValuePresenter.this.getView();
          UIGasMeasureValue _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.MeasureValuesChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateGasMeasureValuePresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIGasMeasureValue> _function = new Procedure1<UIGasMeasureValue>() {
              public void apply(final UIGasMeasureValue it) {
                CreateOrUpdateGasMeasureValuePresenterView _view = CreateOrUpdateGasMeasureValuePresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateGasMeasureValuePresenter.this);
              }
            };
          AsyncCallback<UIGasMeasureValue> _onSuccess = CreateOrUpdateGasMeasureValuePresenter.this.<UIGasMeasureValue>onSuccess(_function);
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
