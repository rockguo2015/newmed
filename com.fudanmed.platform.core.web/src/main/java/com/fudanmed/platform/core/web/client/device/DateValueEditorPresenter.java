package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.DateValueEditorPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.DateValueEditorPresenterView;
import com.fudanmed.platform.core.web.client.device.IValueEditor;
import com.fudanmed.platform.core.web.shared.device.DateValueData;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DateValueEditorPresenter extends WorkbenchAbstractPresenter<DateValueEditorPresenterView> implements IValueEditor {
  @Inject
  protected DateValueEditorPresenterServiceAsync _service;
  
  @Inject
  public DateValueEditorPresenter(final DateValueEditorPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private Procedure0 commiter;
  
  public void setup(final RCAttributeSlotProxy slot, final Procedure1<? super DateValueEditorPresenter> callback) {
    
    final Procedure0 _function = new Procedure0() {
        public void apply() {
          DateValueEditorPresenterView _view = DateValueEditorPresenter.this.getView();
          DateValueData _value = _view.getValue();
          final Procedure1<UIAttributeSlot> _function = new Procedure1<UIAttributeSlot>() {
              public void apply(final UIAttributeSlot it) {
                eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.AttributeSlotChangedEvent(it));
                
              }
            };
          AsyncCallback<UIAttributeSlot> _onSuccess = DateValueEditorPresenter.this.<UIAttributeSlot>onSuccess(_function);
          _service.updateValue(slot, _value, _onSuccess);
        }
      };
    this.commiter = _function;
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Date> _function = new Procedure1<Date>() {
              public void apply(final Date it) {
                DateValueEditorPresenterView _view = DateValueEditorPresenter.this.getView();
                _view.setValue(it);
                callback.apply(DateValueEditorPresenter.this);
              }
            };
          AsyncCallback<Date> _onSuccess = DateValueEditorPresenter.this.<Date>onSuccess(_function);
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
