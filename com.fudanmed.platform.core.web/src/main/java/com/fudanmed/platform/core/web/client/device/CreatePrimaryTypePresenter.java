package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.client.device.CreatePrimaryTypePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreatePrimaryTypePresenterView;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.fudanmed.platform.core.web.shared.device.UIPrimaryAttribute;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreatePrimaryTypePresenter extends WorkbenchAbstractPresenter<CreatePrimaryTypePresenterView> implements CommitablePresenter {
  @Inject
  protected CreatePrimaryTypePresenterServiceAsync _service;
  
  @Inject
  public CreatePrimaryTypePresenter(final CreatePrimaryTypePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure1<? super CommitResultNotifier> commiter;
  
  public void setup4ExtensiableEntity(final RCExtensiableEntityProxy ee, final Procedure1<? super CreatePrimaryTypePresenter> postInit) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreatePrimaryTypePresenterView _view = CreatePrimaryTypePresenter.this.getView();
          UIPrimaryAttribute _value = _view.getValue();
          final Procedure1<UIAttributeSlot> _function = new Procedure1<UIAttributeSlot>() {
              public void apply(final UIAttributeSlot it) {
                eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.AttributeSlotAddedEvent(it));
                
                notifier.success();
              }
            };
          AsyncCallback<UIAttributeSlot> _onSuccess = CreatePrimaryTypePresenter.this.<UIAttributeSlot>onSuccess(_function);
          _service.createExtensiableEntityAttribute(ee, _value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(CreatePrimaryTypePresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void setup4CompositeSlot(final RCAttributeSlotProxy slot, final Procedure1<? super CreatePrimaryTypePresenter> postInit) {
    
    final Procedure1<CommitResultNotifier> _function = new Procedure1<CommitResultNotifier>() {
        public void apply(final CommitResultNotifier notifier) {
          CreatePrimaryTypePresenterView _view = CreatePrimaryTypePresenter.this.getView();
          UIPrimaryAttribute _value = _view.getValue();
          final Procedure1<UIAttributeSlot> _function = new Procedure1<UIAttributeSlot>() {
              public void apply(final UIAttributeSlot it) {
                eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.AttributeSlotAddedEvent(it));
                
                notifier.success();
              }
            };
          AsyncCallback<UIAttributeSlot> _onSuccess = CreatePrimaryTypePresenter.this.<UIAttributeSlot>onSuccess(_function);
          _service.createCompositeSlotAttribute(slot, _value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<String> _function = new Procedure1<String>() {
              public void apply(final String it) {
                CreatePrimaryTypePresenterView _view = CreatePrimaryTypePresenter.this.getView();
                _view.setSlotName(it);
                postInit.apply(CreatePrimaryTypePresenter.this);
              }
            };
          AsyncCallback<String> _onSuccess = CreatePrimaryTypePresenter.this.<String>onSuccess(_function);
          _service.loadSlotName(slot, _onSuccess);
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
