package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DLTaskManagementPresenterView;
import com.fudanmed.platform.core.web.client.deliver.TaskQueryListPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DLTaskManagementPresenter extends WorkbenchAbstractPresenter<DLTaskManagementPresenterView> {
  @Inject
  public DLTaskManagementPresenter(final DLTaskManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public TaskQueryListPresenter initPart(final TaskQueryListPresenter part) {
    this.registerPart(part);
    this.getView().setQueryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private TaskQueryListPresenter queryListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<DLTaskManagementPresenter> _notifier) {
    
    TaskQueryListPresenter _initPart = this.initPart(this.queryListPresenter);
    final Procedure1<TaskQueryListPresenter> _function = new Procedure1<TaskQueryListPresenter>() {
        public void apply(final TaskQueryListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {_notifier.done(DLTaskManagementPresenter.this);
              }
            };
          DLTaskManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<TaskQueryListPresenter>() {
        public void done(TaskQueryListPresenter presenter) {
          _function.apply(presenter);
        }
    });
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
