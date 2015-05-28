package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.workbench.CreateOrUpdateSystemParameterPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.workbench.CreateOrUpdateSystemParameterPresenterView;
import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
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

public class CreateOrUpdateSystemParameterPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateSystemParameterPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateSystemParameterPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateSystemParameterPresenter(final CreateOrUpdateSystemParameterPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final Procedure1<? super CreateOrUpdateSystemParameterPresenter> postInitializer) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UISystemParameter> _function = new Procedure1<UISystemParameter>() {
              public void apply(final UISystemParameter it) {
                CreateOrUpdateSystemParameterPresenterView _view = CreateOrUpdateSystemParameterPresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateSystemParameterPresenter.this);
              }
            };
          AsyncCallback<UISystemParameter> _onSuccess = CreateOrUpdateSystemParameterPresenter.this.<UISystemParameter>onSuccess(_function);
          _service.loadValue(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    CreateOrUpdateSystemParameterPresenterView _view = this.getView();
    UISystemParameter _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.workbench.SystemParametersChangedEvent());
          
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
