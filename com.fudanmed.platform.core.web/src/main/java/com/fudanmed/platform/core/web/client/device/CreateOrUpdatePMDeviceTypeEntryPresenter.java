package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDeviceTypeEntryPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDeviceTypeEntryPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMDeviceTypeEntry;
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

public class CreateOrUpdatePMDeviceTypeEntryPresenter extends WorkbenchAbstractPresenter<CreateOrUpdatePMDeviceTypeEntryPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdatePMDeviceTypeEntryPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdatePMDeviceTypeEntryPresenter(final CreateOrUpdatePMDeviceTypeEntryPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCDeviceTypeProxy value;
  
  public void setup4Update(final RCDeviceTypeProxy value, final IPresenterInitiazerNotifier<CreateOrUpdatePMDeviceTypeEntryPresenter> _notifier) {
    
    this.value = value;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIPMDeviceTypeEntry> _function = new Procedure1<UIPMDeviceTypeEntry>() {
              public void apply(final UIPMDeviceTypeEntry it) {
                CreateOrUpdatePMDeviceTypeEntryPresenterView _view = CreateOrUpdatePMDeviceTypeEntryPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdatePMDeviceTypeEntryPresenter.this);
              }
            };
          AsyncCallback<UIPMDeviceTypeEntry> _onSuccess = CreateOrUpdatePMDeviceTypeEntryPresenter.this.<UIPMDeviceTypeEntry>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    CreateOrUpdatePMDeviceTypeEntryPresenterView _view = this.getView();
    UIPMDeviceTypeEntry _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMDeviceTypeEntrysChangedEvent());
          eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationsChangedEvent());
          
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.updateValue(_value, _onSuccess);
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
