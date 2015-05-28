package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalPatientPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalPatientPresenterView;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalPatient;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.selector.IHasObjectSelectionProvider;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateInHospitalPatientPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateInHospitalPatientPresenterView> implements IHasObjectSelectionProvider<UIInHospitalPatient>, CommitablePresenter {
  @Inject
  protected CreateOrUpdateInHospitalPatientPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateInHospitalPatientPresenter(final CreateOrUpdateInHospitalPatientPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final Procedure1<? super DLInHospitalPatientProxy> createdNotifier, final IPresenterInitiazerNotifier<CreateOrUpdateInHospitalPatientPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateInHospitalPatientPresenterView _view = CreateOrUpdateInHospitalPatientPresenter.this.getView();
          UIInHospitalPatient _value = _view.getValue();
          final Procedure1<DLInHospitalPatientProxy> _function = new Procedure1<DLInHospitalPatientProxy>() {
              public void apply(final DLInHospitalPatientProxy it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.InHospitalPatientsChangedEvent());
                
                createdNotifier.apply(it);
                notifier.success();
              }
            };
          AsyncCallback<DLInHospitalPatientProxy> _onSuccess = CreateOrUpdateInHospitalPatientPresenter.this.<DLInHospitalPatientProxy>onSuccess(_function);
          _service.createValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdateInHospitalPatientPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final DLInHospitalPatientProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateInHospitalPatientPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateInHospitalPatientPresenterView _view = CreateOrUpdateInHospitalPatientPresenter.this.getView();
          UIInHospitalPatient _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.InHospitalPatientsChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateInHospitalPatientPresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIInHospitalPatient> _function = new Procedure1<UIInHospitalPatient>() {
              public void apply(final UIInHospitalPatient it) {
                CreateOrUpdateInHospitalPatientPresenterView _view = CreateOrUpdateInHospitalPatientPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateInHospitalPatientPresenter.this);
              }
            };
          AsyncCallback<UIInHospitalPatient> _onSuccess = CreateOrUpdateInHospitalPatientPresenter.this.<UIInHospitalPatient>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Cxt(final DLInHospitalPatientProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateInHospitalPatientPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdateInHospitalPatientPresenterView _view = CreateOrUpdateInHospitalPatientPresenter.this.getView();
          UIInHospitalPatient _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.deliver.InHospitalPatientsChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdateInHospitalPatientPresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIInHospitalPatient> _function = new Procedure1<UIInHospitalPatient>() {
              public void apply(final UIInHospitalPatient it) {_notifier.done(CreateOrUpdateInHospitalPatientPresenter.this);
              }
            };
          AsyncCallback<UIInHospitalPatient> _onSuccess = CreateOrUpdateInHospitalPatientPresenter.this.<UIInHospitalPatient>onSuccess(_function);
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
  
  public ObjectSelectionProvider<UIInHospitalPatient> getSelectionProvider() {
    
    CreateOrUpdateInHospitalPatientPresenterView _view = this.getView();
    ActionContext<UIInHospitalPatient> _actionContext = _view.getActionContext();
    return _actionContext;
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
