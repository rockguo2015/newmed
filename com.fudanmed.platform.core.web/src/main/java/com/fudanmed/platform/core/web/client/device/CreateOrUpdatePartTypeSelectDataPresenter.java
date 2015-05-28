package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePartTypeSelectDataPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePartTypeSelectDataPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPartTypeSelectData;
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

public class CreateOrUpdatePartTypeSelectDataPresenter extends WorkbenchAbstractPresenter<CreateOrUpdatePartTypeSelectDataPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdatePartTypeSelectDataPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdatePartTypeSelectDataPresenter(final CreateOrUpdatePartTypeSelectDataPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCDeviceTypeProxy parent;
  
  public void setup4Create(final RCDeviceTypeProxy parent, final IPresenterInitiazerNotifier<CreateOrUpdatePartTypeSelectDataPresenter> _notifier) {
    
    this.parent = parent;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(CreateOrUpdatePartTypeSelectDataPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    CreateOrUpdatePartTypeSelectDataPresenterView _view = this.getView();
    UIPartTypeSelectData _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PartTypeSelectChangedEvent());
          
          notifier.success();
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.createValue(this.parent, _value, _onSuccess);
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
