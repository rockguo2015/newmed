package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
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

public class CreateOrUpdatePMWorkItemPresenter extends WorkbenchAbstractPresenter<CreateOrUpdatePMWorkItemPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdatePMWorkItemPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdatePMWorkItemPresenter(final CreateOrUpdatePMWorkItemPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4Create(final Collection<RCDevicePMPlanProxy> selectedItems, final IPresenterInitiazerNotifier<CreateOrUpdatePMWorkItemPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdatePMWorkItemPresenterView _view = CreateOrUpdatePMWorkItemPresenter.this.getView();
          UIPMWorkItem _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdatePMWorkItemPresenter.this.<Void>onSuccess(_function);
          _service.createValue(selectedItems, _value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Collection<UIDevicePMPlan>> _function = new Procedure1<Collection<UIDevicePMPlan>>() {
              public void apply(final Collection<UIDevicePMPlan> it) {
                CreateOrUpdatePMWorkItemPresenterView _view = CreateOrUpdatePMWorkItemPresenter.this.getView();
                _view.setDevicePlans(it);_notifier.done(CreateOrUpdatePMWorkItemPresenter.this);
              }
            };
          AsyncCallback<Collection<UIDevicePMPlan>> _onSuccess = CreateOrUpdatePMWorkItemPresenter.this.<Collection<UIDevicePMPlan>>onSuccess(_function);
          _service.resolveDevicePMPlans(selectedItems, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCPMWorkItemProxy value, final IPresenterInitiazerNotifier<CreateOrUpdatePMWorkItemPresenter> _notifier) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreateOrUpdatePMWorkItemPresenterView _view = CreateOrUpdatePMWorkItemPresenter.this.getView();
          UIPMWorkItem _value = _view.getValue();
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent());
                
                notifier.success();
              }
            };
          AsyncCallback<Void> _onSuccess = CreateOrUpdatePMWorkItemPresenter.this.<Void>onSuccess(_function);
          _service.updateValue(_value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIPMWorkItem> _function = new Procedure1<UIPMWorkItem>() {
              public void apply(final UIPMWorkItem it) {
                CreateOrUpdatePMWorkItemPresenterView _view = CreateOrUpdatePMWorkItemPresenter.this.getView();
                _view.setValue(it);
                final Procedure1<Collection<UIDevicePMPlan>> _function = new Procedure1<Collection<UIDevicePMPlan>>() {
                    public void apply(final Collection<UIDevicePMPlan> it) {
                      CreateOrUpdatePMWorkItemPresenterView _view = CreateOrUpdatePMWorkItemPresenter.this.getView();
                      _view.setDevicePlans(it);_notifier.done(CreateOrUpdatePMWorkItemPresenter.this);
                    }
                  };
                AsyncCallback<Collection<UIDevicePMPlan>> _onSuccess = CreateOrUpdatePMWorkItemPresenter.this.<Collection<UIDevicePMPlan>>onSuccess(_function);
                _service.loadAssignedDevicePlans(value, _onSuccess);
              }
            };
          AsyncCallback<UIPMWorkItem> _onSuccess = CreateOrUpdatePMWorkItemPresenter.this.<UIPMWorkItem>onSuccess(_function);
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
