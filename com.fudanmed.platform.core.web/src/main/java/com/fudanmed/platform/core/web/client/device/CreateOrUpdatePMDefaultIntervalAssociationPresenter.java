package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDefaultIntervalAssociationPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDefaultIntervalAssociationPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMDefaultIntervalAssociation;
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

public class CreateOrUpdatePMDefaultIntervalAssociationPresenter extends WorkbenchAbstractPresenter<CreateOrUpdatePMDefaultIntervalAssociationPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdatePMDefaultIntervalAssociationPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdatePMDefaultIntervalAssociationPresenter(final CreateOrUpdatePMDefaultIntervalAssociationPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final RCPMDeviceTypeEntryProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdatePMDefaultIntervalAssociationPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdatePMDefaultIntervalAssociationPresenterView _view = CreateOrUpdatePMDefaultIntervalAssociationPresenter.this.getView();
          UIPMDefaultIntervalAssociation _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationsChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdatePMDefaultIntervalAssociationPresenter.this.<Void>onSuccess(_function);
          _service.createValue(_value, parent, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdatePMDefaultIntervalAssociationPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCPMDefaultIntervalAssociationProxy value, final IPresenterInitiazerNotifier<CreateOrUpdatePMDefaultIntervalAssociationPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdatePMDefaultIntervalAssociationPresenterView _view = CreateOrUpdatePMDefaultIntervalAssociationPresenter.this.getView();
          UIPMDefaultIntervalAssociation _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationsChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdatePMDefaultIntervalAssociationPresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIPMDefaultIntervalAssociation> _function = new Procedure1<UIPMDefaultIntervalAssociation>() {
              public void apply(final UIPMDefaultIntervalAssociation it) {
                CreateOrUpdatePMDefaultIntervalAssociationPresenterView _view = CreateOrUpdatePMDefaultIntervalAssociationPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdatePMDefaultIntervalAssociationPresenter.this);
              }
            };
          AsyncCallback<UIPMDefaultIntervalAssociation> _onSuccess = CreateOrUpdatePMDefaultIntervalAssociationPresenter.this.<UIPMDefaultIntervalAssociation>onSuccess(_function);
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
