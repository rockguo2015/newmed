package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMWorkItemPropertyPresenter extends WorkbenchAbstractPresenter<PMWorkItemPropertyPresenterView> implements IContextConsumer<RCPMWorkItemProxy> {
  @Inject
  protected PMWorkItemPropertyPresenterServiceAsync _service;
  
  @Inject
  public PMWorkItemPropertyPresenter(final PMWorkItemPropertyPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<PMWorkItemPropertyPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(PMWorkItemPropertyPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setContext(final ActionContext<RCPMWorkItemProxy> ac) {
    
    final Procedure1<Iterable<RCPMWorkItemProxy>> _function = new Procedure1<Iterable<RCPMWorkItemProxy>>() {
        public void apply(final Iterable<RCPMWorkItemProxy> selections) {
          int _size = IterableExtensions.size(selections);
          boolean _equals = (_size == 1);
          if (_equals) {
            RCPMWorkItemProxy _head = IterableExtensions.<RCPMWorkItemProxy>head(selections);
            PMWorkItemPropertyPresenter.this.setValue(_head);
          } else {
            PMWorkItemPropertyPresenterView _view = PMWorkItemPropertyPresenter.this.getView();
            _view.clear();
          }
        }
      };
    ac.addSelectionChangedListener(new SelectionChangedListener<RCPMWorkItemProxy>() {
        public void selectionChanged(Iterable<RCPMWorkItemProxy> selections) {
          _function.apply(selections);
        }
    });
  }
  
  public void setValue(final RCPMWorkItemProxy value) {
    
    final Procedure1<UIPMWorkItem> _function = new Procedure1<UIPMWorkItem>() {
        public void apply(final UIPMWorkItem it) {
          getView().setValue(it);
          
        }
      };
    AsyncCallback<UIPMWorkItem> _onSuccess = this.<UIPMWorkItem>onSuccess(_function);
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
