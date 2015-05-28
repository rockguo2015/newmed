package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateFaultLevelColorAdaptorPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateFaultLevelColorAdaptorPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
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

public class CreateOrUpdateFaultLevelColorAdaptorPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateFaultLevelColorAdaptorPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateFaultLevelColorAdaptorPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateFaultLevelColorAdaptorPresenter(final CreateOrUpdateFaultLevelColorAdaptorPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup4Update(final RCFaultLevelColorAdaptorProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateFaultLevelColorAdaptorPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIFaultLevelColorAdaptor> _function = new Procedure1<UIFaultLevelColorAdaptor>() {
              public void apply(final UIFaultLevelColorAdaptor it) {
                CreateOrUpdateFaultLevelColorAdaptorPresenterView _view = CreateOrUpdateFaultLevelColorAdaptorPresenter.this.getView();
                _view.setValue(it);_notifier.done(CreateOrUpdateFaultLevelColorAdaptorPresenter.this);
              }
            };
          AsyncCallback<UIFaultLevelColorAdaptor> _onSuccess = CreateOrUpdateFaultLevelColorAdaptorPresenter.this.<UIFaultLevelColorAdaptor>onSuccess(_function);
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
    
    CreateOrUpdateFaultLevelColorAdaptorPresenterView _view = this.getView();
    UIFaultLevelColorAdaptor _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorsChangedEvent());
          
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
