package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateWorkItemTaskPresenter;
import com.fudanmed.platform.core.web.client.project.GroupTaskFinishReportPresenter;
import com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.GroupTaskManagementPresenterView;
import com.fudanmed.platform.core.web.client.project.GroupTaskMisDispatchReportPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemCancelPendPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemFinishOutsourcePresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemFinishReportPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemFollowUpPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemMisDispatchingPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemOutsourcePresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemPendPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemTaskListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListPresenter;
import com.fudanmed.platform.core.web.shared.project.UIGroupTask;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.google.common.base.Function;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Timer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;
import com.uniquesoft.gwt.client.common.print.Print;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.domain.document.proxy.IHasDocumentsProxy;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class GroupTaskManagementPresenter extends WorkbenchAbstractPresenter<GroupTaskManagementPresenterView> {
  @Inject
  protected GroupTaskManagementPresenterServiceAsync _service;
  
  @Inject
  public GroupTaskManagementPresenter(final GroupTaskManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public WorkItemTaskListPresenter initPart(final WorkItemTaskListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemTaskListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemTaskListPresenter WorkItemTaskListPresenter;
  
  public RepairTaskDetailInfoPresenter initPart(final RepairTaskDetailInfoPresenter part) {
    this.registerPart(part);
    this.getView().setRepairTaskDetailInfoPresenter(part);
    return part;
    
  }
  
  @Inject
  private RepairTaskDetailInfoPresenter repairTaskDetailInfoPresenter;
  
  public WorkItemStorageListPresenter initPart(final WorkItemStorageListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemStorageListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemStorageListPresenter workItemStorageListPresenter;
  
  public PictureListPresenter initPart(final PictureListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkitemPictureListPresenter(part);
    return part;
    
  }
  
  @Inject
  private PictureListPresenter workitemPictureListPresenter;
  
  @Inject
  private Provider<CreateOrUpdateWorkItemTaskPresenter> createOrUpdateWorkItemTaskPresenter;
  
  @Inject
  private Provider<GroupTaskFinishReportPresenter> groupTaskFinishReportPresenter;
  
  @Inject
  private Provider<GroupTaskMisDispatchReportPresenter> groupTaskMisDispatchReportPresenter;
  
  @Inject
  private Provider<WorkItemFinishReportPresenter> workItemFinishReportPresenter;
  
  @Inject
  private Provider<WorkItemOutsourcePresenter> workItemOutsourcePresenter;
  
  @Inject
  private Provider<WorkItemFinishOutsourcePresenter> workItemFinishOutsourcePresenter;
  
  @Inject
  private Provider<WorkItemPendPresenter> workItemPendPresenter;
  
  @Inject
  private Provider<WorkItemCancelPendPresenter> workItemCancelPendPresenter;
  
  @Inject
  private Provider<WorkItemMisDispatchingPresenter> workItemMisDispatchingPresenter;
  
  @Inject
  private Provider<WorkItemFollowUpPresenter> workItemFollowUpPresenter;
  
  private Timer timer;
  
  public void postDeactivated() {
    
    this.timer.cancel();
  }
  
  public void setup(final IPresenterInitiazerNotifier<GroupTaskManagementPresenter> _notifier) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String name) {
          getView().setTeamName(name);
          
          WorkItemTaskListPresenter _initPart = GroupTaskManagementPresenter.this.initPart(GroupTaskManagementPresenter.this.WorkItemTaskListPresenter);
          final Procedure1<WorkItemTaskListPresenter> _function = new Procedure1<WorkItemTaskListPresenter>() {
              public void apply(final WorkItemTaskListPresenter it) {
                RepairTaskDetailInfoPresenter _initPart = GroupTaskManagementPresenter.this.initPart(GroupTaskManagementPresenter.this.repairTaskDetailInfoPresenter);
                final Procedure1<RepairTaskDetailInfoPresenter> _function = new Procedure1<RepairTaskDetailInfoPresenter>() {
                    public void apply(final RepairTaskDetailInfoPresenter it) {
                      WorkItemStorageListPresenter _initPart = GroupTaskManagementPresenter.this.initPart(GroupTaskManagementPresenter.this.workItemStorageListPresenter);
                      final Procedure1<WorkItemStorageListPresenter> _function = new Procedure1<WorkItemStorageListPresenter>() {
                          public void apply(final WorkItemStorageListPresenter it) {
                            PictureListPresenter _initPart = GroupTaskManagementPresenter.this.initPart(GroupTaskManagementPresenter.this.workitemPictureListPresenter);
                            final Procedure1<PictureListPresenter> _function = new Procedure1<PictureListPresenter>() {
                                public void apply(final PictureListPresenter it) {
                                  final Procedure1<Void> _function = new Procedure1<Void>() {
                                      public void apply(final Void it) {
                                        GroupTaskManagementPresenterView _view = GroupTaskManagementPresenter.this.getView();
                                        ActionContext<UIGroupTask> _actionContext = _view.getActionContext();
                                        final Function1<UIGroupTask,IHasDocumentsProxy> _function = new Function1<UIGroupTask,IHasDocumentsProxy>() {
                                            public IHasDocumentsProxy apply(final UIGroupTask it) {
                                              RCGroupTaskProxy _proxy = it.toProxy();
                                              return ((IHasDocumentsProxy) _proxy);
                                            }
                                          };
                                        ActionContext<IHasDocumentsProxy> _adapt = _actionContext.<IHasDocumentsProxy>adapt(new Function<UIGroupTask,IHasDocumentsProxy>() {
                                            public IHasDocumentsProxy apply(UIGroupTask input) {
                                              return _function.apply(input);
                                            }
                                        });
                                        GroupTaskManagementPresenter.this.workitemPictureListPresenter.setContext(_adapt);getView().refresh();
                                        
                                        GroupTaskManagementPresenter.this.installDirtyCheck();_notifier.done(GroupTaskManagementPresenter.this);
                                      }
                                    };
                                  GroupTaskManagementPresenter.this.activate(new IPostInitializeAction() {
                                      public void initializeFinished(Void v) {
                                        _function.apply(v);
                                      }
                                  });
                                }
                              };
                            _initPart.setup(new IPresenterInitiazerNotifier<PictureListPresenter>() {
                                public void done(PictureListPresenter presenter) {
                                  _function.apply(presenter);
                                }
                            });
                          }
                        };
                      _initPart.setup(_function);
                    }
                  };
                _initPart.setup(_function);
              }
            };
          _initPart.setup(_function);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.getTeamName(_onSuccess);
  }
  
  public void installDirtyCheck() {
    
    Timer _timer = new Timer();
    this.timer = _timer;
    final Procedure1<Timer> _function = new Procedure1<Timer>() {
        public void apply(final Timer timer) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                final Procedure1<ConfigurableAsyncCallback<Boolean>> _function = new Procedure1<ConfigurableAsyncCallback<Boolean>>() {
                    public void apply(final ConfigurableAsyncCallback<Boolean> it) {
                      final Procedure1<Boolean> _function = new Procedure1<Boolean>() {
                          public void apply(final Boolean isDirty) {
                            if ((isDirty).booleanValue()) {getView().markAsDirty();
                              
                            }
                          }
                        };
                      it.onSuccessDo(_function);
                      final Procedure1<Throwable> _function_1 = new Procedure1<Throwable>() {
                          public void apply(final Throwable it) {
                            Info.display("\u9519\u8BEF", "\u5237\u65B0\u6570\u636E\u9519\u8BEF\uFF0C\u53EF\u80FD\u7F51\u7EDC\u4E2D\u65AD");
                          }
                        };
                      it.onFailureDo(_function_1);
                    }
                  };
                ConfigurableAsyncCallback<Boolean> _callback = ConfigurableAsyncCallback.<Boolean>callback(_function);
                _service.isDirty(_callback);
                boolean _isActivated = GroupTaskManagementPresenter.this.getIsActivated();
                if (_isActivated) {
                  int _multiply = (1000 * 10);
                  timer.schedule(_multiply);
                } else {
                  timer.cancel();
                }
              }
            };
          timer.setProcess(_function);
        }
      };
    Timer _doubleArrow = ObjectExtensions.<Timer>operator_doubleArrow(this.timer, _function);
    int _multiply = (1000 * 10);
    _doubleArrow.schedule(_multiply);
  }
  
  public void view_filterRequestExecution(final UIGroupTaskCriteria c) {
    
    final Procedure1<IPagedResult<UIGroupTask>> _function = new Procedure1<IPagedResult<UIGroupTask>>() {
        public void apply(final IPagedResult<UIGroupTask> it) {
          getView().showResults(it);
          getView().resetDirty();
          
        }
      };
    AsyncCallback<IPagedResult<UIGroupTask>> _onSuccess = this.<IPagedResult<UIGroupTask>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_GroupTasksChanged() {
    getView().refresh();
    
  }
  
  public void view_showGroupTaskDetailRequestExecution(final RCGroupTaskProxy groupTask) {
    
    this.WorkItemTaskListPresenter.setValue(groupTask);
    this.workItemStorageListPresenter.setGroupTask(groupTask);
    final Procedure1<RCRepairTaskProxy> _function = new Procedure1<RCRepairTaskProxy>() {
        public void apply(final RCRepairTaskProxy it) {
          GroupTaskManagementPresenter.this.repairTaskDetailInfoPresenter.setRepairTask(it);
        }
      };
    AsyncCallback<RCRepairTaskProxy> _onSuccess = this.<RCRepairTaskProxy>onSuccess(_function);
    _service.getRepairTask(groupTask, _onSuccess);
  }
  
  public void view_createWorkItemTaskRequestExecution(final RCGroupTaskProxy groupTask) {
    
    CreateOrUpdateWorkItemTaskPresenter _get = this.createOrUpdateWorkItemTaskPresenter.get();
    final Procedure1<CreateOrUpdateWorkItemTaskPresenter> _function = new Procedure1<CreateOrUpdateWorkItemTaskPresenter>() {
        public void apply(final CreateOrUpdateWorkItemTaskPresenter it) {
          final Procedure1<CreateOrUpdateWorkItemTaskPresenter> _function = new Procedure1<CreateOrUpdateWorkItemTaskPresenter>() {
              public void apply(final CreateOrUpdateWorkItemTaskPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(groupTask, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateWorkItemTaskPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_finishGroupTaskRequestExecution(final RCGroupTaskProxy groupTask) {
    
    GroupTaskFinishReportPresenter _get = this.groupTaskFinishReportPresenter.get();
    final Procedure1<GroupTaskFinishReportPresenter> _function = new Procedure1<GroupTaskFinishReportPresenter>() {
        public void apply(final GroupTaskFinishReportPresenter it) {
          final Procedure1<GroupTaskFinishReportPresenter> _function = new Procedure1<GroupTaskFinishReportPresenter>() {
              public void apply(final GroupTaskFinishReportPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(groupTask, _function);
        }
      };
    ObjectExtensions.<GroupTaskFinishReportPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_misDispatchGroupTaskRequestExecution(final RCGroupTaskProxy groupTask) {
    
    GroupTaskMisDispatchReportPresenter _get = this.groupTaskMisDispatchReportPresenter.get();
    final Procedure1<GroupTaskMisDispatchReportPresenter> _function = new Procedure1<GroupTaskMisDispatchReportPresenter>() {
        public void apply(final GroupTaskMisDispatchReportPresenter it) {
          final Procedure1<GroupTaskMisDispatchReportPresenter> _function = new Procedure1<GroupTaskMisDispatchReportPresenter>() {
              public void apply(final GroupTaskMisDispatchReportPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(groupTask, new IPresenterInitiazerNotifier<GroupTaskMisDispatchReportPresenter>() {
              public void done(GroupTaskMisDispatchReportPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<GroupTaskMisDispatchReportPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_finishWorkItemTaskRequestExecution(final RCWorkItemTaskProxy workItemTask) {
    
    WorkItemFinishReportPresenter _get = this.workItemFinishReportPresenter.get();
    final Procedure1<WorkItemFinishReportPresenter> _function = new Procedure1<WorkItemFinishReportPresenter>() {
        public void apply(final WorkItemFinishReportPresenter it) {
          final Procedure1<WorkItemFinishReportPresenter> _function = new Procedure1<WorkItemFinishReportPresenter>() {
              public void apply(final WorkItemFinishReportPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(workItemTask, _function);
        }
      };
    ObjectExtensions.<WorkItemFinishReportPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_pendWorkItemTaskRequestExecution(final RCWorkItemTaskProxy workItemTask) {
    
    WorkItemPendPresenter _get = this.workItemPendPresenter.get();
    final Procedure1<WorkItemPendPresenter> _function = new Procedure1<WorkItemPendPresenter>() {
        public void apply(final WorkItemPendPresenter it) {
          final Procedure1<WorkItemPendPresenter> _function = new Procedure1<WorkItemPendPresenter>() {
              public void apply(final WorkItemPendPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(workItemTask, _function);
        }
      };
    ObjectExtensions.<WorkItemPendPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_cancelPendWorkItemTaskRequestExecution(final RCWorkItemTaskProxy workItemTask) {
    
    WorkItemCancelPendPresenter _get = this.workItemCancelPendPresenter.get();
    final Procedure1<WorkItemCancelPendPresenter> _function = new Procedure1<WorkItemCancelPendPresenter>() {
        public void apply(final WorkItemCancelPendPresenter it) {
          final Procedure1<WorkItemCancelPendPresenter> _function = new Procedure1<WorkItemCancelPendPresenter>() {
              public void apply(final WorkItemCancelPendPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(workItemTask, _function);
        }
      };
    ObjectExtensions.<WorkItemCancelPendPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_outsourceWorkItemTaskRequestExecution(final RCWorkItemTaskProxy workItemTask) {
    
    WorkItemOutsourcePresenter _get = this.workItemOutsourcePresenter.get();
    final Procedure1<WorkItemOutsourcePresenter> _function = new Procedure1<WorkItemOutsourcePresenter>() {
        public void apply(final WorkItemOutsourcePresenter it) {
          final Procedure1<WorkItemOutsourcePresenter> _function = new Procedure1<WorkItemOutsourcePresenter>() {
              public void apply(final WorkItemOutsourcePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(workItemTask, _function);
        }
      };
    ObjectExtensions.<WorkItemOutsourcePresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_finishOutsourceWorkItemTaskRequestExecution(final RCWorkItemTaskProxy workItemTask) {
    
    WorkItemFinishOutsourcePresenter _get = this.workItemFinishOutsourcePresenter.get();
    final Procedure1<WorkItemFinishOutsourcePresenter> _function = new Procedure1<WorkItemFinishOutsourcePresenter>() {
        public void apply(final WorkItemFinishOutsourcePresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup(workItemTask, _function);
  }
  
  public void view_misDispatchingWorkItemTaskRequestExecution(final RCWorkItemTaskProxy workItemTask) {
    
    WorkItemMisDispatchingPresenter _get = this.workItemMisDispatchingPresenter.get();
    final Procedure1<WorkItemMisDispatchingPresenter> _function = new Procedure1<WorkItemMisDispatchingPresenter>() {
        public void apply(final WorkItemMisDispatchingPresenter it) {
          final Procedure1<WorkItemMisDispatchingPresenter> _function = new Procedure1<WorkItemMisDispatchingPresenter>() {
              public void apply(final WorkItemMisDispatchingPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(workItemTask, _function);
        }
      };
    ObjectExtensions.<WorkItemMisDispatchingPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_followUpWOrkItemTaskRequestExecution(final RCWorkItemTaskProxy workItemTask) {
    
    WorkItemFollowUpPresenter _get = this.workItemFollowUpPresenter.get();
    final Procedure1<WorkItemFollowUpPresenter> _function = new Procedure1<WorkItemFollowUpPresenter>() {
        public void apply(final WorkItemFollowUpPresenter it) {
          final Procedure1<WorkItemFollowUpPresenter> _function = new Procedure1<WorkItemFollowUpPresenter>() {
              public void apply(final WorkItemFollowUpPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(workItemTask, _function);
        }
      };
    ObjectExtensions.<WorkItemFollowUpPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_printWorkItemRequestExecution(final RCWorkItemTaskProxy workItemTask) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String html) {
          Print.it(html);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.generatePrintContents(workItemTask, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIGroupTaskCriteria>(){
    			
    			public void execute(UIGroupTaskCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.GroupTasksChangedEvent.__type__, new com.fudanmed.platform.core.web.client.project.GroupTasksChangedHandler(){
    public void GroupTasksChanged(){
    	_eventbus_GroupTasksChanged();
    }
    }));
    getView().showGroupTaskDetailRequest(new RequestHandler1<RCGroupTaskProxy>(){
    			
    			public void execute(RCGroupTaskProxy groupTask){
    				view_showGroupTaskDetailRequestExecution(groupTask);
    			}
    			
    		});
    getView().createWorkItemTaskRequest(new RequestHandler1<RCGroupTaskProxy>(){
    			
    			public void execute(RCGroupTaskProxy groupTask){
    				view_createWorkItemTaskRequestExecution(groupTask);
    			}
    			
    		});
    getView().finishGroupTaskRequest(new RequestHandler1<RCGroupTaskProxy>(){
    			
    			public void execute(RCGroupTaskProxy groupTask){
    				view_finishGroupTaskRequestExecution(groupTask);
    			}
    			
    		});
    getView().misDispatchGroupTaskRequest(new RequestHandler1<RCGroupTaskProxy>(){
    			
    			public void execute(RCGroupTaskProxy groupTask){
    				view_misDispatchGroupTaskRequestExecution(groupTask);
    			}
    			
    		});
    getView().finishWorkItemTaskRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItemTask){
    				view_finishWorkItemTaskRequestExecution(workItemTask);
    			}
    			
    		});
    getView().pendWorkItemTaskRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItemTask){
    				view_pendWorkItemTaskRequestExecution(workItemTask);
    			}
    			
    		});
    getView().cancelPendWorkItemTaskRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItemTask){
    				view_cancelPendWorkItemTaskRequestExecution(workItemTask);
    			}
    			
    		});
    getView().outsourceWorkItemTaskRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItemTask){
    				view_outsourceWorkItemTaskRequestExecution(workItemTask);
    			}
    			
    		});
    getView().finishOutsourceWorkItemTaskRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItemTask){
    				view_finishOutsourceWorkItemTaskRequestExecution(workItemTask);
    			}
    			
    		});
    getView().misDispatchingWorkItemTaskRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItemTask){
    				view_misDispatchingWorkItemTaskRequestExecution(workItemTask);
    			}
    			
    		});
    getView().followUpWOrkItemTaskRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItemTask){
    				view_followUpWOrkItemTaskRequestExecution(workItemTask);
    			}
    			
    		});
    getView().printWorkItemRequest(new RequestHandler1<RCWorkItemTaskProxy>(){
    			
    			public void execute(RCWorkItemTaskProxy workItemTask){
    				view_printWorkItemRequestExecution(workItemTask);
    			}
    			
    		});
    
  }
}
