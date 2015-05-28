package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.client.project.WorkItemTask4WorkersStatListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.WorkItemTask4WorkersStatListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersStatCriteriaData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemTask4WorkersStatListPresenter extends WorkbenchAbstractPresenter<WorkItemTask4WorkersStatListPresenterView> {
  @Inject
  protected WorkItemTask4WorkersStatListPresenterServiceAsync _service;
  
  @Inject
  public WorkItemTask4WorkersStatListPresenter(final WorkItemTask4WorkersStatListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<WorkItemTask4WorkersStatListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(WorkItemTask4WorkersStatListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setCriteria(final RCMaintenanceTeamProxy team, final Date dateFrom, final Date dateTo) {
    
    UIWorkItemTask4WorkersCriteria _uIWorkItemTask4WorkersCriteria = new UIWorkItemTask4WorkersCriteria();
    final Procedure1<UIWorkItemTask4WorkersCriteria> _function = new Procedure1<UIWorkItemTask4WorkersCriteria>() {
        public void apply(final UIWorkItemTask4WorkersCriteria it) {
          it.setDepartment(team);
          it.setDateFrom(dateFrom);
          it.setDateTo(dateTo);
        }
      };
    final UIWorkItemTask4WorkersCriteria uicriteria = ObjectExtensions.<UIWorkItemTask4WorkersCriteria>operator_doubleArrow(_uIWorkItemTask4WorkersCriteria, _function);
    this.setCriteria(uicriteria);
  }
  
  public void setCriteria(final UIWorkItemTask4WorkersCriteria uicriteria) {
    
    final Procedure1<Collection<UIWorkItemTask4WorkersStatCriteriaData>> _function = new Procedure1<Collection<UIWorkItemTask4WorkersStatCriteriaData>>() {
        public void apply(final Collection<UIWorkItemTask4WorkersStatCriteriaData> it) {
          WorkItemTask4WorkersStatListPresenterView _view = WorkItemTask4WorkersStatListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIWorkItemTask4WorkersStatCriteriaData>> _onSuccess = this.<Collection<UIWorkItemTask4WorkersStatCriteriaData>>onSuccess(_function);
    _service.load(uicriteria, _onSuccess);
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
