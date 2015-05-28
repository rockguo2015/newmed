package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemEvaluate;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMWorkItemEvaluatePropertyViewPresenter extends WorkbenchAbstractPresenter<PMWorkItemEvaluatePropertyViewPresenterView> {
  @Inject
  protected PMWorkItemEvaluatePropertyViewPresenterServiceAsync _service;
  
  @Inject
  public PMWorkItemEvaluatePropertyViewPresenter(final PMWorkItemEvaluatePropertyViewPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCPMWorkItemProxy value;
  
  public void setup(final IPresenterInitiazerNotifier<PMWorkItemEvaluatePropertyViewPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(PMWorkItemEvaluatePropertyViewPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCPMWorkItemProxy value, final IPresenterInitiazerNotifier<PMWorkItemEvaluatePropertyViewPresenter> _notifier) {
    
    this.value = value;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIPMWorkItemEvaluate> _function = new Procedure1<UIPMWorkItemEvaluate>() {
              public void apply(final UIPMWorkItemEvaluate it) {
                getView().setValue(it);
                _notifier.done(PMWorkItemEvaluatePropertyViewPresenter.this);
              }
            };
          AsyncCallback<UIPMWorkItemEvaluate> _onSuccess = PMWorkItemEvaluatePropertyViewPresenter.this.<UIPMWorkItemEvaluate>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setPMWorkItem(final RCPMWorkItemProxy value) {
    
    final Procedure1<UIPMWorkItemEvaluate> _function = new Procedure1<UIPMWorkItemEvaluate>() {
        public void apply(final UIPMWorkItemEvaluate it) {
          getView().setValue(it);
          
        }
      };
    AsyncCallback<UIPMWorkItemEvaluate> _onSuccess = this.<UIPMWorkItemEvaluate>onSuccess(_function);
    _service.loadValue(value, _onSuccess);
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
