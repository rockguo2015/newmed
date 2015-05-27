package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateAppFunctionAssignmentPresenterServiceAsync;
import edu.fudan.langlab.uidl.domain.app.client.security.CreateOrUpdateAppFunctionAssignmentPresenterView;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppFunctionAssignment;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateAppFunctionAssignmentPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateAppFunctionAssignmentPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateAppFunctionAssignmentPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateAppFunctionAssignmentPresenter(final CreateOrUpdateAppFunctionAssignmentPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private UIAppRole role;
  
  public void setup(final UIAppRole role, final Procedure1<? super CreateOrUpdateAppFunctionAssignmentPresenter> postInitializer) {
    
    this.role = role;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          String _roleId = role.getRoleId();
          final Procedure1<UIAppFunctionAssignment> _function = new Procedure1<UIAppFunctionAssignment>() {
              public void apply(final UIAppFunctionAssignment it) {
                CreateOrUpdateAppFunctionAssignmentPresenterView _view = CreateOrUpdateAppFunctionAssignmentPresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateAppFunctionAssignmentPresenter.this);
              }
            };
          AsyncCallback<UIAppFunctionAssignment> _onSuccess = CreateOrUpdateAppFunctionAssignmentPresenter.this.<UIAppFunctionAssignment>onSuccess(_function);
          _service.loadValue(_roleId, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    CreateOrUpdateAppFunctionAssignmentPresenterView _view = this.getView();
    UIAppFunctionAssignment _value = _view.getValue();
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.security.AppFunctionAssignmentsChangedEvent(CreateOrUpdateAppFunctionAssignmentPresenter.this.role));
          
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
