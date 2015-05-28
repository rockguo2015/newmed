package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.EmployeeUploaderPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.organization.EmployeeUploaderPresenterView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;
import com.uniquesoft.gwt.shared.datatype.File;
import edu.fudan.langlab.gxt.client.validation.CSVClientExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class EmployeeUploaderPresenter extends WorkbenchAbstractPresenter<EmployeeUploaderPresenterView> implements CommitablePresenter {
  @Inject
  protected EmployeeUploaderPresenterServiceAsync _service;
  
  @Inject
  public EmployeeUploaderPresenter(final EmployeeUploaderPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    EmployeeUploaderPresenterView _view = this.getView();
    File _file = _view.getFile();
    final Procedure1<ConfigurableAsyncCallback<Void>> _function = new Procedure1<ConfigurableAsyncCallback<Void>>() {
        public void apply(final ConfigurableAsyncCallback<Void> it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                notifier.success();eventBus.fireEvent(new com.fudanmed.platform.core.web.client.organization.EmployeesChangedEvent());
                
              }
            };
          it.onSuccessDo(_function);
          final Procedure1<Throwable> _function_1 = new Procedure1<Throwable>() {
              public void apply(final Throwable caught) {
                CSVClientExtensions.showErrors(caught);
              }
            };
          it.onFailureDo(_function_1);
        }
      };
    ConfigurableAsyncCallback<Void> _callback = ConfigurableAsyncCallback.<Void>callback(_function);
    _service.doUpload(_file, _callback);
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
