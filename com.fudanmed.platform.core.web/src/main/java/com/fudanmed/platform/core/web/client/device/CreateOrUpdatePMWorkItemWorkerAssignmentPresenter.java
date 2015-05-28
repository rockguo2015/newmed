package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView;
import com.fudanmed.platform.core.web.client.device.PrintPMWorkItemAssignmentCommand;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenterView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.web.shared.device.UIWorkItemPlanAssignment;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdatePMWorkItemWorkerAssignmentPresenter extends WorkbenchAbstractPresenter<CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdatePMWorkItemWorkerAssignmentPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdatePMWorkItemWorkerAssignmentPresenter(final CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public WorkItemPlanAssignmentListPresenter initPart(final WorkItemPlanAssignmentListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemPlanAssignmentListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter;
  
  @Inject
  private PrintPMWorkItemAssignmentCommand printPMWorkItemAssignmentCommand;
  
  private boolean used4Update;
  
  private RCPMWorkItemProxy parent;
  
  public void setup4Create(final RCPMWorkItemProxy parent, final Procedure1<? super CreateOrUpdatePMWorkItemWorkerAssignmentPresenter> postInitializer) {
    
    WorkItemPlanAssignmentListPresenter _initPart = this.initPart(this.workItemPlanAssignmentListPresenter);
    final Procedure1<WorkItemPlanAssignmentListPresenter> _function = new Procedure1<WorkItemPlanAssignmentListPresenter>() {
        public void apply(final WorkItemPlanAssignmentListPresenter it) {
          CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.used4Update = false;
          CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.parent = parent;
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                final Procedure1<RCOrganizationProxy> _function = new Procedure1<RCOrganizationProxy>() {
                    public void apply(final RCOrganizationProxy it) {
                      CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.getView();
                      final Procedure1<Void> _function = new Procedure1<Void>() {
                          public void apply(final Void it) {
                            postInitializer.apply(CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this);
                          }
                        };
                      _view.setTeam(it, _function);
                    }
                  };
                AsyncCallback<RCOrganizationProxy> _onSuccess = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.<RCOrganizationProxy>onSuccess(_function);
                _service.loadTeamOrg4WorkItem(parent, _onSuccess);
              }
            };
          CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup4UnassignedItems(Boolean.valueOf(true), parent, new IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter>() {
        public void done(WorkItemPlanAssignmentListPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void setup4Update(final RCPMWorkItemWorkerAssignmentProxy value, final Procedure1<? super CreateOrUpdatePMWorkItemWorkerAssignmentPresenter> postInitializer) {
    
    WorkItemPlanAssignmentListPresenter _initPart = this.initPart(this.workItemPlanAssignmentListPresenter);
    final Procedure1<WorkItemPlanAssignmentListPresenter> _function = new Procedure1<WorkItemPlanAssignmentListPresenter>() {
        public void apply(final WorkItemPlanAssignmentListPresenter it) {
          CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.used4Update = true;
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                final Procedure1<RCOrganizationProxy> _function = new Procedure1<RCOrganizationProxy>() {
                    public void apply(final RCOrganizationProxy it) {
                      CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.getView();
                      final Procedure1<Void> _function = new Procedure1<Void>() {
                          public void apply(final Void it) {
                            final Procedure1<UIPMWorkItemWorkerAssignment> _function = new Procedure1<UIPMWorkItemWorkerAssignment>() {
                                public void apply(final UIPMWorkItemWorkerAssignment it) {
                                  CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.getView();
                                  _view.setValue(it);
                                  postInitializer.apply(CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this);
                                }
                              };
                            AsyncCallback<UIPMWorkItemWorkerAssignment> _onSuccess = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.<UIPMWorkItemWorkerAssignment>onSuccess(_function);
                            _service.loadValue(value, _onSuccess);
                          }
                        };
                      _view.setTeam(it, _function);
                    }
                  };
                AsyncCallback<RCOrganizationProxy> _onSuccess = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.<RCOrganizationProxy>onSuccess(_function);
                _service.loadTeamOrg4WorkItem(CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.parent, _onSuccess);
              }
            };
          CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup4UnassignedItems(Boolean.valueOf(true), this.parent, new IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter>() {
        public void done(WorkItemPlanAssignmentListPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view = this.getView();
      UIPMWorkItemWorkerAssignment _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
      CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view_1 = this.getView();
      UIPMWorkItemWorkerAssignment _value_1 = _view_1.getValue();
      Boolean _print = _value_1.getPrint();
      if ((_print).booleanValue()) {
        CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view_2 = this.getView();
        UIPMWorkItemWorkerAssignment _value_2 = _view_2.getValue();
        RCPMWorkItemWorkerAssignmentProxy _proxy = _value_2.toProxy();
        this.printPMWorkItemAssignmentCommand.execute(_proxy);
      }
    } else {
      WorkItemPlanAssignmentListPresenterView _view_3 = this.workItemPlanAssignmentListPresenter.getView();
      Collection<UIWorkItemPlanAssignment> _selectedValues = _view_3.getSelectedValues();
      CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view_4 = this.getView();
      UIPMWorkItemWorkerAssignment _value_3 = _view_4.getValue();
      final Procedure1<RCPMWorkItemWorkerAssignmentProxy> _function_1 = new Procedure1<RCPMWorkItemWorkerAssignmentProxy>() {
          public void apply(final RCPMWorkItemWorkerAssignmentProxy it) {
            CreateOrUpdatePMWorkItemWorkerAssignmentPresenterView _view = CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.getView();
            UIPMWorkItemWorkerAssignment _value = _view.getValue();
            Boolean _print = _value.getPrint();
            if ((_print).booleanValue()) {
              CreateOrUpdatePMWorkItemWorkerAssignmentPresenter.this.printPMWorkItemAssignmentCommand.execute(it);
            }eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<RCPMWorkItemWorkerAssignmentProxy> _onSuccess_1 = this.<RCPMWorkItemWorkerAssignmentProxy>onSuccess(_function_1);
      _service.createValue(_selectedValues, this.parent, _value_3, _onSuccess_1);
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
