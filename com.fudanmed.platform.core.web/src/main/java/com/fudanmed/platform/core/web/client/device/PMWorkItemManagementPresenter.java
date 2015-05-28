package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanSelectorPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemEvaluatePropertyViewPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.device.PMWorkItemManagementPresenterView;
import com.fudanmed.platform.core.web.client.device.PMWorkItemPropertyPresenter;
import com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemCriteria;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMWorkItemManagementPresenter extends WorkbenchAbstractPresenter<PMWorkItemManagementPresenterView> {
  @Inject
  protected PMWorkItemManagementPresenterServiceAsync _service;
  
  @Inject
  public PMWorkItemManagementPresenter(final PMWorkItemManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdatePMWorkItemPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<DevicePMPlanSelectorPresenter> createPresenter;
  
  @Inject
  private Provider<DevicePMPlanSelectorPresenter> devicePMPlanSelectorPresenter;
  
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
  
  public void setup(final IPresenterInitiazerNotifier<PMWorkItemManagementPresenter> _notifier) {
    
    PMWorkItemWorkerAssignmentListPresenter _initPart = this.initPart(this.workItemWorkerAssignmentListPresenter);
    final Procedure1<PMWorkItemWorkerAssignmentListPresenter> _function = new Procedure1<PMWorkItemWorkerAssignmentListPresenter>() {
        public void apply(final PMWorkItemWorkerAssignmentListPresenter it) {
          WorkItemPlanAssignmentListPresenter _initPart = PMWorkItemManagementPresenter.this.initPart(PMWorkItemManagementPresenter.this.workItemPlanAssignmentListPresenter);
          final Procedure1<WorkItemPlanAssignmentListPresenter> _function = new Procedure1<WorkItemPlanAssignmentListPresenter>() {
              public void apply(final WorkItemPlanAssignmentListPresenter it) {
                PMWorkItemEvaluatePropertyViewPresenter _initPart = PMWorkItemManagementPresenter.this.initPart(PMWorkItemManagementPresenter.this.workItemEvaluatePropertyViewPresenter);
                final Procedure1<PMWorkItemEvaluatePropertyViewPresenter> _function = new Procedure1<PMWorkItemEvaluatePropertyViewPresenter>() {
                    public void apply(final PMWorkItemEvaluatePropertyViewPresenter it) {
                      PMWorkItemPropertyPresenter _initPart = PMWorkItemManagementPresenter.this.initPart(PMWorkItemManagementPresenter.this.workItemPropertyPresenter);
                      final Procedure1<PMWorkItemPropertyPresenter> _function = new Procedure1<PMWorkItemPropertyPresenter>() {
                          public void apply(final PMWorkItemPropertyPresenter it) {
                            final Procedure1<Void> _function = new Procedure1<Void>() {
                                public void apply(final Void it) {getView().refresh();
                                  _notifier.done(PMWorkItemManagementPresenter.this);
                                }
                              };
                            PMWorkItemManagementPresenter.this.activate(new IPostInitializeAction() {
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
          _initPart.setup(Boolean.valueOf(true), new IPresenterInitiazerNotifier<WorkItemPlanAssignmentListPresenter>() {
              public void done(WorkItemPlanAssignmentListPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    _initPart.setup(_function);
  }
  
  public void view_createRequestExecution() {
    
    DevicePMPlanSelectorPresenter _get = this.createPresenter.get();
    final Procedure1<DevicePMPlanSelectorPresenter> _function = new Procedure1<DevicePMPlanSelectorPresenter>() {
        public void apply(final DevicePMPlanSelectorPresenter it) {
          final Procedure1<DevicePMPlanSelectorPresenter> _function = new Procedure1<DevicePMPlanSelectorPresenter>() {
              public void apply(final DevicePMPlanSelectorPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4CreateWorkItem(new IPresenterInitiazerNotifier<DevicePMPlanSelectorPresenter>() {
              public void done(DevicePMPlanSelectorPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<DevicePMPlanSelectorPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_finishWorkItemRequestExecution(final RCPMWorkItemProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.finishWorkItem(value, _onSuccess);
  }
  
  public void view_modifyRequestExecution(final RCPMWorkItemProxy value) {
    
    CreateOrUpdatePMWorkItemPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdatePMWorkItemPresenter> _function = new Procedure1<CreateOrUpdatePMWorkItemPresenter>() {
        public void apply(final CreateOrUpdatePMWorkItemPresenter it) {
          final Procedure1<CreateOrUpdatePMWorkItemPresenter> _function = new Procedure1<CreateOrUpdatePMWorkItemPresenter>() {
              public void apply(final CreateOrUpdatePMWorkItemPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdatePMWorkItemPresenter>() {
              public void done(CreateOrUpdatePMWorkItemPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdatePMWorkItemPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRequestExecution(final RCPMWorkItemProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void view_selectedPlansRequestExecution(final RCPMWorkItemProxy value) {
    
    DevicePMPlanSelectorPresenter _get = this.devicePMPlanSelectorPresenter.get();
    final Procedure1<DevicePMPlanSelectorPresenter> _function = new Procedure1<DevicePMPlanSelectorPresenter>() {
        public void apply(final DevicePMPlanSelectorPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup(value, new IPresenterInitiazerNotifier<DevicePMPlanSelectorPresenter>() {
        public void done(DevicePMPlanSelectorPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_pmworkitemSelectedExecution(final RCPMWorkItemProxy value) {
    
    this.workItemPlanAssignmentListPresenter.setPMWorkItem(value);
    this.workItemWorkerAssignmentListPresenter.setPMWorkItem(value);
    this.workItemEvaluatePropertyViewPresenter.setPMWorkItem(value);
  }
  
  public void view_filterRequestExecution(final UIPMWorkItemCriteria c) {
    
    UIPMWorkItemStatue _status = c.getStatus();
    boolean _equals = Objects.equal(_status, UIPMWorkItemStatue.finished);
    if (_equals) {
      c.setIncludeFinishedItems(Boolean.valueOf(true));
    }
    final Procedure1<IPagedResult<UIPMWorkItem>> _function = new Procedure1<IPagedResult<UIPMWorkItem>>() {
        public void apply(final IPagedResult<UIPMWorkItem> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIPMWorkItem>> _onSuccess = this.<IPagedResult<UIPMWorkItem>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_PMWorkItemWorkerAssignmentsChanged() {
    getView().refresh();
    
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
    getView().createRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_createRequestExecution();
    			}
    			
    		});
    getView().finishWorkItemRequest(new RequestHandler1<RCPMWorkItemProxy>(){
    			
    			public void execute(RCPMWorkItemProxy value){
    				view_finishWorkItemRequestExecution(value);
    			}
    			
    		});
    getView().modifyRequest(new RequestHandler1<RCPMWorkItemProxy>(){
    			
    			public void execute(RCPMWorkItemProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCPMWorkItemProxy>(){
    			
    			public void execute(RCPMWorkItemProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    getView().selectedPlansRequest(new RequestHandler1<RCPMWorkItemProxy>(){
    			
    			public void execute(RCPMWorkItemProxy value){
    				view_selectedPlansRequestExecution(value);
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
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.PMWorkItemWorkerAssignmentsChangedHandler(){
    public void PMWorkItemWorkerAssignmentsChanged(){
    	_eventbus_PMWorkItemWorkerAssignmentsChanged();
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.device.PMWorkItemsChangedHandler(){
    public void PMWorkItemsChanged(){
    	_eventbus_PMWorkItemsChanged();
    }
    }));
    
  }
}
