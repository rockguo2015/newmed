package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentPresenter;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter;
import com.fudanmed.platform.core.web.client.device.CreatePMWorkItemTeamFinishReportPresenter;
import com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.PMTeamWorkItemManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMTeamWorkItemManagementPresenter extends WorkbenchAbstractPresenter<PMTeamWorkItemManagementPresenterView> {
  @Inject
  protected PMTeamWorkItemManagementPresenterServiceAsync _service;
  
  @Inject
  public PMTeamWorkItemManagementPresenter(final PMTeamWorkItemManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdatePMWorkItemWorkerAssignmentPresenter> createOrUpdatePMWorkItemWorkerAssignmentPresenter;
  
  @Inject
  private Provider<CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter> createOrUpdatePMWorkItemWorkerAssignmentReportPresenter;
  
  @Inject
  private Provider<CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter> createOrUpdatePMWorkItemWorkerAssignmentPendPresenter;
  
  @Inject
  private Provider<CreatePMWorkItemTeamFinishReportPresenter> createPMWorkItemTeamFinishReportPresenter;
  
  public WorkItemPlanAssignmentListPresenter initPart(final WorkItemPlanAssignmentListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemPlanAssignmentListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemPlanAssignmentListPresenter workItemPlanAssignmentListPresenter;
  
  public PMWorkItemWorkerAssignmentListPresenter initPart(final PMWorkItemWorkerAssignmentListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemWorkerAssignmentListPresenter(part);
    return part;
    
  }
  
  @Inject
  private PMWorkItemWorkerAssignmentListPresenter workItemWorkerAssignmentListPresenter;
  
  public PMWorkItemEvaluatePropertyViewPresenter initPart(final PMWorkItemEvaluatePropertyViewPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemEvaluatePropertyViewPresenter(part);
    return part;
    
  }
  
  @Inject
  private PMWorkItemEvaluatePropertyViewPresenter workItemEvaluatePropertyViewPresenter;
  
  public PMWorkItemPropertyPresenter initPart(final PMWorkItemPropertyPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemPropertyPresenter(part);
    return part;
    
  }
  
  @Inject
  private PMWorkItemPropertyPresenter workItemPropertyPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<PMTeamWorkItemManagementPresenter> _notifier) {
    
    PMWorkItemWorkerAssignmentListPresenter _initPart = this.initPart(this.workItemWorkerAssignmentListPresenter);
    final Procedure1<PMWorkItemWorkerAssignmentListPresenter> _function = new Procedure1<PMWorkItemWorkerAssignmentListPresenter>() {
        public void apply(final PMWorkItemWorkerAssignmentListPresenter it) {
          WorkItemPlanAssignmentListPresenter _initPart = PMTeamWorkItemManagementPresenter.this.initPart(PMTeamWorkItemManagementPresenter.this.workItemPlanAssignmentListPresenter);
          final Procedure1<WorkItemPlanAssignmentListPresenter> _function = new Procedure1<WorkItemPlanAssignmentListPresenter>() {
              public void apply(final WorkItemPlanAssignmentListPresenter it) {
                PMWorkItemEvaluatePropertyViewPresenter _initPart = PMTeamWorkItemManagementPresenter.this.initPart(PMTeamWorkItemManagementPresenter.this.workItemEvaluatePropertyViewPresenter);
                final Procedure1<PMWorkItemEvaluatePropertyViewPresenter> _function = new Procedure1<PMWorkItemEvaluatePropertyViewPresenter>() {
                    public void apply(final PMWorkItemEvaluatePropertyViewPresenter it) {
                      PMWorkItemPropertyPresenter _initPart = PMTeamWorkItemManagementPresenter.this.initPart(PMTeamWorkItemManagementPresenter.this.workItemPropertyPresenter);
                      final Procedure1<PMWorkItemPropertyPresenter> _function = new Procedure1<PMWorkItemPropertyPresenter>() {
                          public void apply(final PMWorkItemPropertyPresenter it) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {getView().refresh();
                                  _notifier.done(PMTeamWorkItemManagementPresenter.this);
                                }
                              };
                            PMTeamWorkItemManagementPresenter.this.activate(new IPostInitializeAction() {
                                public void initializeFinished(Void v) {
                                  _function.apply(v);
                                }
                            });
                          }
                        };
                      _initPart.setup(new IPresenterInitiazerNotifier<PMWorkItemPropertyPresenter>() {
                          public void done(PMWorkItemPropertyPresenter presenter) {
                            _function.apply(presenter);
                          }
                      });
                    }
                  };
                _initPart.setup(new IPresenterInitiazerNotifier<PMWorkItemEvaluatePropertyViewPresenter>() {
                    public void done(PMWorkItemEvaluatePropertyViewPresenter presenter) {
                      _function.apply(presenter);
                    }
                });
              }
            };
          _initPart.setup(Boolean.valueOf(false), new IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter>() {
              public void done(WorkItemPlanAssignmentListPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    _initPart.setup(_function);
  }
  
  public void view_reportFinishRequestExecution(final RCPMWorkItemWorkerAssignmentProxy value) {
    
    CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter _get = this.createOrUpdatePMWorkItemWorkerAssignmentReportPresenter.get();
    final Procedure1<CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter> _function = new Procedure1<CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter>() {
        public void apply(final CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter>() {
        public void done(CreateOrUpdatePMWorkItemWorkerAssignmentReportPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_pendRequestExecution(final RCPMWorkItemWorkerAssignmentProxy value) {
    
    CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter _get = this.createOrUpdatePMWorkItemWorkerAssignmentPendPresenter.get();
    final Procedure1<CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter> _function = new Procedure1<CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter>() {
        public void apply(final CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter>() {
        public void done(CreateOrUpdatePMWorkItemWorkerAssignmentPendPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_assignWorkerRequestExecution(final RCPMWorkItemProxy value) {
    
    CreateOrUpdatePMWorkItemWorkerAssignmentPresenter _get = this.createOrUpdatePMWorkItemWorkerAssignmentPresenter.get();
    final Procedure1<CreateOrUpdatePMWorkItemWorkerAssignmentPresenter> _function = new Procedure1<CreateOrUpdatePMWorkItemWorkerAssignmentPresenter>() {
        public void apply(final CreateOrUpdatePMWorkItemWorkerAssignmentPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup4Create(value, _function);
  }
  
  public void view_reportAllFinishRequestExecution(final RCPMWorkItemProxy value) {
    
    CreatePMWorkItemTeamFinishReportPresenter _get = this.createPMWorkItemTeamFinishReportPresenter.get();
    final Procedure1<CreatePMWorkItemTeamFinishReportPresenter> _function = new Procedure1<CreatePMWorkItemTeamFinishReportPresenter>() {
        public void apply(final CreatePMWorkItemTeamFinishReportPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup(value, new IPresenterInitiazerNotifier<CreatePMWorkItemTeamFinishReportPresenter>() {
        public void done(CreatePMWorkItemTeamFinishReportPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_pmworkitemSelectedExecution(final RCPMWorkItemProxy value) {
    
    this.workItemPlanAssignmentListPresenter.setPMWorkItem(value);
    this.workItemWorkerAssignmentListPresenter.setPMWorkItem(value);
    this.workItemEvaluatePropertyViewPresenter.setPMWorkItem(value);
    this.workItemPropertyPresenter.setValue(value);
  }
  
  public void view_filterRequestExecution(final UIPMWorkItemCriteria c) {
    
    final Procedure1<IPagedResult<UIPMWorkItem>> _function = new Procedure1<IPagedResult<UIPMWorkItem>>() {
        public void apply(final IPagedResult<UIPMWorkItem> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIPMWorkItem>> _onSuccess = this.<IPagedResult<UIPMWorkItem>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_PMWorkItemsChanged() {
    getView().refresh();
    
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().reportFinishRequest(new RequestHandler1<RCPMWorkItemWorkerAssignmentProxy>(){
    			
    			public void execute(RCPMWorkItemWorkerAssignmentProxy value){
    				view_reportFinishRequestExecution(value);
    			}
    			
    		});
    getView().pendRequest(new RequestHandler1<RCPMWorkItemWorkerAssignmentProxy>(){
    			
    			public void execute(RCPMWorkItemWorkerAssignmentProxy value){
    				view_pendRequestExecution(value);
    			}
    			
    		});
    getView().assignWorkerRequest(new RequestHandler1<RCPMWorkItemProxy>(){
    			
    			public void execute(RCPMWorkItemProxy value){
    				view_assignWorkerRequestExecution(value);
    			}
    			
    		});
    getView().reportAllFinishRequest(new RequestHandler1<RCPMWorkItemProxy>(){
    			
    			public void execute(RCPMWorkItemProxy value){
    				view_reportAllFinishRequestExecution(value);
    			}
    			
    		});
    getView().pmworkitemSelected(new RequestHandler1<RCPMWorkItemProxy>(){
    			
    			public void execute(RCPMWorkItemProxy value){
    				view_pmworkitemSelectedExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UIPMWorkItemCriteria>(){
    			
    			public void execute(UIPMWorkItemCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedHandler(){
    public void PMWorkItemsChanged(){
    	_eventbus_PMWorkItemsChanged();
    }
    }));
    
  }
}
