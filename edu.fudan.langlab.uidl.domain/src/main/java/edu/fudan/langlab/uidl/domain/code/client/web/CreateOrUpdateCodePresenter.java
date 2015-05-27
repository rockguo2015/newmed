package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import edu.fudan.langlab.domain.code.proxy.CodeProxy;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.code.client.web.CreateOrUpdateCodePresenterServiceAsync;
import edu.fudan.langlab.uidl.domain.code.client.web.CreateOrUpdateCodePresenterView;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICode;
import edu.fudan.langlab.uidl.domain.code.shared.web.UICodeType;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateCodePresenter extends WorkbenchAbstractPresenter<CreateOrUpdateCodePresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateCodePresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateCodePresenter(final CreateOrUpdateCodePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private UICodeType codeType;
  
  public void setCodeType(final UICodeType codeType) {
    
    this.codeType = codeType;
  }
  
  public void setValue(final CodeProxy code) {
    
    this.used4Update = true;
    final Procedure1<UICode> _function = new Procedure1<UICode>() {
        public void apply(final UICode it) {
          CreateOrUpdateCodePresenterView _view = CreateOrUpdateCodePresenter.this.getView();
          _view.setValue(it);
        }
      };
    AsyncCallback<UICode> _onSuccess = this.<UICode>onSuccess(_function);
    _service.loadValue(code, _onSuccess);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdateCodePresenterView _view = this.getView();
      UICode _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.code.client.web.CodesChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateCodePresenterView _view_1 = this.getView();
      UICode _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.code.client.web.CodesChangedEvent());
            
            notifier.success();
            CreateOrUpdateCodePresenterView _view = CreateOrUpdateCodePresenter.this.getView();
            UICode _value = _view.getValue();
            Boolean _inputNext = _value.getInputNext();
            boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_inputNext);
            if (_isLogicTrue) {
              eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.code.client.web.InputNextCodeEvent(CreateOrUpdateCodePresenter.this.codeType));
              
            }
          }
        };
      AsyncCallback<Void> _onSuccess_1 = this.<Void>onSuccess(_function_1);
      _service.createValue(this.codeType, _value_1, _onSuccess_1);
    }
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
