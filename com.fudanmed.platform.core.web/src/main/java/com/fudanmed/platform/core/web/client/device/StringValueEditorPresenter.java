package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.IValueEditor;
import com.fudanmed.platform.core.web.client.device.StringValueEditorPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.StringValueEditorPresenterView;
import com.fudanmed.platform.core.web.shared.device.StringValueData;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class StringValueEditorPresenter extends WorkbenchAbstractPresenter<StringValueEditorPresenterView> implements IValueEditor {
  @Inject
  protected StringValueEditorPresenterServiceAsync _service;
  
  @Inject
  public StringValueEditorPresenter(final StringValueEditorPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure0 commiter;
  
  public void setup(final RCAttributeSlotProxy slot, final Procedure1<? super StringValueEditorPresenter> callback) {
    
    final Procedure0 _function = new Procedure0() {
        public void apply() {
          StringValueEditorPresenterView _view = StringValueEditorPresenter.this.getView();
          StringValueData _value = _view.getValue();
          final Procedure1<UIAttributeSlot> _function = new Procedure1<UIAttributeSlot>() {
              public void apply(final UIAttributeSlot it) {
                eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.AttributeSlotChangedEvent(it));
                
              }
            };
          AsyncCallback<UIAttributeSlot> _onSuccess = StringValueEditorPresenter.this.<UIAttributeSlot>onSuccess(_function);
          _service.updateValue(slot, _value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<String> _function = new Procedure1<String>() {
              public void apply(final String it) {
                StringValueEditorPresenterView _view = StringValueEditorPresenter.this.getView();
                _view.setValue(it);
                callback.apply(StringValueEditorPresenter.this);
              }
            };
          AsyncCallback<String> _onSuccess = StringValueEditorPresenter.this.<String>onSuccess(_function);
          _service.loadValue(slot, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function_1.apply(v);
        }
    });
  }
  
  public void performCommit() {
    
    this.commiter.apply();
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
