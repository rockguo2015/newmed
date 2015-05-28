package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.PMEngineerReportPresenterView;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMEngineerReportPresenter extends WorkbenchAbstractPresenter<PMEngineerReportPresenterView> {
  @Inject
  public PMEngineerReportPresenter(final PMEngineerReportPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public WorkItemPlanAssignmentListPresenter initPart(final WorkItemPlanAssignmentListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemPlanAssignmentListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter;
  
  public void setup(final RCPMWorkItemWorkerAssignmentProxy workerAssignment, final IPresenterInitiazerNotifier<PMEngineerReportPresenter> _notifier) {
    
    WorkItemPlanAssignmentListPresenter _initPart = this.initPart(this.workItemPlanAssignmentListPresenter);
    final Procedure1<WorkItemPlanAssignmentListPresenter> _function = new Procedure1<WorkItemPlanAssignmentListPresenter>() {
        public void apply(final WorkItemPlanAssignmentListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {_notifier.done(PMEngineerReportPresenter.this);
              }
            };
          PMEngineerReportPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup4WorkerReport(Boolean.valueOf(true), workerAssignment, new IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter>() {
        public void done(WorkItemPlanAssignmentListPresenter presenter) {
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
