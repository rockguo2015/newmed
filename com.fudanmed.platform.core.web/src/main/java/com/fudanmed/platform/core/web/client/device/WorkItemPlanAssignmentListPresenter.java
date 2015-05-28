package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemPlanAssignmentListPresenter extends WorkbenchAbstractPresenter<WorkItemPlanAssignmentListPresenterView> {
  @Inject
  protected WorkItemPlanAssignmentListPresenterServiceAsync _service;
  
  @Inject
  public WorkItemPlanAssignmentListPresenter(final WorkItemPlanAssignmentListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private RCPMWorkItemProxy context;
  
  private RCPMWorkItemWorkerAssignmentProxy assignment;
  
  private Boolean unassignedOnly;
  
  public void setup(final Boolean multiSelect, final IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter> _notifier) {
    
    WorkItemPlanAssignmentListPresenterView _view = this.getView();
    _view.supportMultiSelect(multiSelect);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(WorkItemPlanAssignmentListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup(final Boolean multiSelect, final RCPMWorkItemProxy context, final IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter> _notifier) {
    
    this.context = context;
    WorkItemPlanAssignmentListPresenterView _view = this.getView();
    _view.supportMultiSelect(multiSelect);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          WorkItemPlanAssignmentListPresenter.this.refresh();_notifier.done(WorkItemPlanAssignmentListPresenter.this);
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
  
  public void setup4UnassignedItems(final Boolean multiSelect, final RCPMWorkItemProxy context, final IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter> _notifier) {
    
    WorkItemPlanAssignmentListPresenterView _view = this.getView();
    _view.supportMultiSelect(multiSelect);
    this.unassignedOnly = Boolean.valueOf(true);
    this.context = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          WorkItemPlanAssignmentListPresenter.this.refresh();_notifier.done(WorkItemPlanAssignmentListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4WorkerReport(final Boolean multiSelect, final RCPMWorkItemWorkerAssignmentProxy context, final IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter> _notifier) {
    
    WorkItemPlanAssignmentListPresenterView _view = this.getView();
    _view.supportMultiSelect(multiSelect);
    this.assignment = context;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          WorkItemPlanAssignmentListPresenter.this.refresh();_notifier.done(WorkItemPlanAssignmentListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void refresh() {
    
    boolean _notEquals = (!Objects.equal(this.assignment, null));
    if (_notEquals) {
      final Procedure1<Collection<UIWorkItemPlanAssignment>> _function = new Procedure1<Collection<UIWorkItemPlanAssignment>>() {
          public void apply(final Collection<UIWorkItemPlanAssignment> items) {
            getView().setResults(items);
            
          }
        };
      AsyncCallback<Collection<UIWorkItemPlanAssignment>> _onSuccess = this.<Collection<UIWorkItemPlanAssignment>>onSuccess(_function);
      _service.loadWorkItemPlanAssignment4WorkerList(this.assignment, _onSuccess);
    }
    boolean _notEquals_1 = (!Objects.equal(this.context, null));
    if (_notEquals_1) {
      boolean _isLogicTrue = BooleanExtensions.isLogicTrue(this.unassignedOnly);
      boolean _not = (!_isLogicTrue);
      if (_not) {
        final Procedure1<Collection<UIWorkItemPlanAssignment>> _function_1 = new Procedure1<Collection<UIWorkItemPlanAssignment>>() {
            public void apply(final Collection<UIWorkItemPlanAssignment> items) {
              getView().setResults(items);
              
            }
          };
        AsyncCallback<Collection<UIWorkItemPlanAssignment>> _onSuccess_1 = this.<Collection<UIWorkItemPlanAssignment>>onSuccess(_function_1);
        _service.loadWorkItemPlanAssignmentList(this.context, _onSuccess_1);
      } else {
        final Procedure1<Collection<UIWorkItemPlanAssignment>> _function_2 = new Procedure1<Collection<UIWorkItemPlanAssignment>>() {
            public void apply(final Collection<UIWorkItemPlanAssignment> items) {
              getView().setResults(items);
              
            }
          };
        AsyncCallback<Collection<UIWorkItemPlanAssignment>> _onSuccess_2 = this.<Collection<UIWorkItemPlanAssignment>>onSuccess(_function_2);
        _service.loadUnassignedWorkItemPlanAssignmentList(this.context, _onSuccess_2);
      }
    }
  }
  
  public void _eventbus_DevicePMPlansChanged() {
    
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
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedHandler(){
    public void DevicePMPlansChanged(){
    	_eventbus_DevicePMPlansChanged();
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentsChangedHandler(){
    public void WorkItemPlanAssignmentsChanged(){
    	_eventbus_WorkItemPlanAssignmentsChanged();
    }
    }));
    
  }
}
