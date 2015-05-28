package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMWorkItemWorkerAssignmentListPresenter extends WorkbenchAbstractPresenter<PMWorkItemWorkerAssignmentListPresenterView> {
  @Inject
  protected PMWorkItemWorkerAssignmentListPresenterServiceAsync _service;
  
  @Inject
  public PMWorkItemWorkerAssignmentListPresenter(final PMWorkItemWorkerAssignmentListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCPMWorkItemProxy context;
  
  public void setup(final Procedure1<? super PMWorkItemWorkerAssignmentListPresenter> postInit) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          postInit.apply(PMWorkItemWorkerAssignmentListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final RCPMWorkItemProxy context, final Procedure1<? super PMWorkItemWorkerAssignmentListPresenter> postInit) {
    
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          PMWorkItemWorkerAssignmentListPresenter.this.refresh();
          postInit.apply(PMWorkItemWorkerAssignmentListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setPMWorkItem(final RCPMWorkItemProxy context) {
    
    this.context = context;
    this.refresh();
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.context, null));
    if (_notEquals) {
      final Procedure1<Collection<UIPMWorkItemWorkerAssignment>> _function = new Procedure1<Collection<UIPMWorkItemWorkerAssignment>>() {
          public void apply(final Collection<UIPMWorkItemWorkerAssignment> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIPMWorkItemWorkerAssignment>> _onSuccess = this.<Collection<UIPMWorkItemWorkerAssignment>>onSuccess(_function);
      _service.loadPMWorkItemWorkerAssignmentList(this.context, _onSuccess);
    }
  }
  
  public void _eventbus_PMWorkItemWorkerAssignmentsChanged() {
    
    this.refresh();
  }
  
  public void _eventbus_WorkItemPlanAssignmentsChanged() {
    
    this.refresh();
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentsChangedHandler(){
    public void PMWorkItemWorkerAssignmentsChanged(){
    	_eventbus_PMWorkItemWorkerAssignmentsChanged();
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentsChangedHandler(){
    public void WorkItemPlanAssignmentsChanged(){
    	_eventbus_WorkItemPlanAssignmentsChanged();
    }
    }));
    
  }
}
