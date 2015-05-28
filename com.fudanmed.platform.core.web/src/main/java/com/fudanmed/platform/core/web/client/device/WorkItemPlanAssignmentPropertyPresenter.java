package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentPropertyPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentPropertyPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.widgets.ObjectSelectionProvider.SelectionChangedListener;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemPlanAssignmentPropertyPresenter extends WorkbenchAbstractPresenter<WorkItemPlanAssignmentPropertyPresenterView> implements IContextConsumer<RCWorkItemPlanAssignmentProxy> {
  @Inject
  protected WorkItemPlanAssignmentPropertyPresenterServiceAsync _service;
  
  @Inject
  public WorkItemPlanAssignmentPropertyPresenter(final WorkItemPlanAssignmentPropertyPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<WorkItemPlanAssignmentPropertyPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(WorkItemPlanAssignmentPropertyPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setContext(final ActionContext<RCWorkItemPlanAssignmentProxy> ac) {
    
    final Procedure1<Iterable<RCWorkItemPlanAssignmentProxy>> _function = new Procedure1<Iterable<RCWorkItemPlanAssignmentProxy>>() {
        public void apply(final Iterable<RCWorkItemPlanAssignmentProxy> selections) {
          int _size = IterableExtensions.size(selections);
          boolean _equals = (_size == 1);
          if (_equals) {
            RCWorkItemPlanAssignmentProxy _head = IterableExtensions.<RCWorkItemPlanAssignmentProxy>head(selections);
            WorkItemPlanAssignmentPropertyPresenter.this.setValue(_head);
          } else {
            WorkItemPlanAssignmentPropertyPresenterView _view = WorkItemPlanAssignmentPropertyPresenter.this.getView();
            _view.clear();
          }
        }
      };
    ac.addSelectionChangedListener(new SelectionChangedListener<RCWorkItemPlanAssignmentProxy>() {
        public void selectionChanged(Iterable<RCWorkItemPlanAssignmentProxy> selections) {
          _function.apply(selections);
        }
    });
  }
  
  public void setValue(final RCWorkItemPlanAssignmentProxy value) {
    
    final Procedure1<UIWorkItemPlanAssignment> _function = new Procedure1<UIWorkItemPlanAssignment>() {
        public void apply(final UIWorkItemPlanAssignment it) {
          getView().setValue(it);
          
        }
      };
    AsyncCallback<UIWorkItemPlanAssignment> _onSuccess = this.<UIWorkItemPlanAssignment>onSuccess(_function);
    _service.loadValue(value, _onSuccess);
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
