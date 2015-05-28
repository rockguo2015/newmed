package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalLocationPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalLocationPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
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

public class CreateOrUpdateInHospitalLocationPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateInHospitalLocationPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateInHospitalLocationPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateInHospitalLocationPresenter(final CreateOrUpdateInHospitalLocationPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final IPresenterInitiazerNotifier<CreateOrUpdateInHospitalLocationPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateInHospitalLocationPresenterView _view = CreateOrUpdateInHospitalLocationPresenter.this.getView();
          UIInHospitalLocation _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.InHospitalLocationsChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateInHospitalLocationPresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateInHospitalLocationPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final DLInHospitalLocationProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateInHospitalLocationPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateInHospitalLocationPresenterView _view = CreateOrUpdateInHospitalLocationPresenter.this.getView();
          UIInHospitalLocation _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.InHospitalLocationsChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateInHospitalLocationPresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIInHospitalLocation> _function = new Procedure1<UIInHospitalLocation>() {
              public void apply(final UIInHospitalLocation it) {
                CreateOrUpdateInHospitalLocationPresenterView _view = CreateOrUpdateInHospitalLocationPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateInHospitalLocationPresenter.this);
              }
            };
          AsyncCallback<UIInHospitalLocation> _onSuccess = CreateOrUpdateInHospitalLocationPresenter.this.<UIInHospitalLocation>onSuccess(_function);
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
