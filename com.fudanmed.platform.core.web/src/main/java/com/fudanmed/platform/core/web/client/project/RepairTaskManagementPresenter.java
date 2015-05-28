package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairTaskPresenter;
import com.fudanmed.platform.core.web.client.project.RepairDispatchPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.RepairTaskManagementPresenterView;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenter;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Timer;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairTaskManagementPresenter extends WorkbenchAbstractPresenter<RepairTaskManagementPresenterView> {
  @Inject
  protected RepairTaskManagementPresenterServiceAsync _service;
  
  @Inject
  public RepairTaskManagementPresenter(final RepairTaskManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateRepairTaskPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<RepairDispatchPresenter> repairDispatchPresenter;
  
  public RepairTaskTreeInfoPresenter initPart(final RepairTaskTreeInfoPresenter part) {
    this.registerPart(part);
    this.getView().setRepairTaskInfoPresenter(part);
    return part;
    
  }
  
  @Inject
  private RepairTaskTreeInfoPresenter repairTaskInfoPresenter;
  
  private Timer timer;
  
  public void postDeactivated() {
    
    this.timer.cancel();
  }
  
  public void setup(final IPresenterInitiazerNotifier<RepairTaskManagementPresenter> _notifier) {
    
    RepairTaskTreeInfoPresenter _initPart = this.initPart(this.repairTaskInfoPresenter);
    final Procedure1<RepairTaskTreeInfoPresenter> _function = new Procedure1<RepairTaskTreeInfoPresenter>() {
        public void apply(final RepairTaskTreeInfoPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {getView().refresh();
                
                RepairTaskManagementPresenter.this.installDirtyCheck();_notifier.done(RepairTaskManagementPresenter.this);
              }
            };
          RepairTaskManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(_function);
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
                boolean _isActivated = RepairTaskManagementPresenter.this.getIsActivated();
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
  
  public void view_createRequestExecution() {
    
    CreateOrUpdateRepairTaskPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateRepairTaskPresenter> _function = new Procedure1<CreateOrUpdateRepairTaskPresenter>() {
        public void apply(final CreateOrUpdateRepairTaskPresenter it) {
          final Procedure1<CreateOrUpdateRepairTaskPresenter> _function = new Procedure1<CreateOrUpdateRepairTaskPresenter>() {
              public void apply(final CreateOrUpdateRepairTaskPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(new IPresenterInitiazerNotifier<CreateOrUpdateRepairTaskPresenter>() {
              public void done(CreateOrUpdateRepairTaskPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateRepairTaskPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_modifyRequestExecution(final RCRepairTaskProxy value) {
    
    CreateOrUpdateRepairTaskPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateRepairTaskPresenter> _function = new Procedure1<CreateOrUpdateRepairTaskPresenter>() {
        public void apply(final CreateOrUpdateRepairTaskPresenter it) {
          final Procedure1<CreateOrUpdateRepairTaskPresenter> _function = new Procedure1<CreateOrUpdateRepairTaskPresenter>() {
              public void apply(final CreateOrUpdateRepairTaskPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateRepairTaskPresenter>() {
              public void done(CreateOrUpdateRepairTaskPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    ObjectExtensions.<CreateOrUpdateRepairTaskPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_deleteRequestExecution(final RCRepairTaskProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.RepairTasksChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(value, _onSuccess);
  }
  
  public void view_cancelRequestExecution(final RCRepairTaskProxy value) {
    
    final Procedure1<ConfigurableAsyncCallback<Void>> _function = new Procedure1<ConfigurableAsyncCallback<Void>>() {
        public void apply(final ConfigurableAsyncCallback<Void> it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.RepairTasksChangedEvent());
                
              }
            };
          it.onSuccessDo(_function);
          final Procedure1<Throwable> _function_1 = new Procedure1<Throwable>() {
              public void apply(final Throwable it) {
                Info.display("\u9519\u8BEF", "\u65E0\u6CD5\u53D6\u6D88\uFF0C\u8BF7\u5237\u65B0\u786E\u8BA4\u62A5\u4FEE\u72B6\u6001");
              }
            };
          it.onFailureDo(_function_1);
        }
      };
    ConfigurableAsyncCallback<Void> _callback = ConfigurableAsyncCallback.<Void>callback(_function);
    _service.cancel(value, _callback);
  }
  
  public void view_filterRequestExecution(final UIRepairTaskCriteria c) {
    
    final Procedure1<IPagedResult<UIRepairTask>> _function = new Procedure1<IPagedResult<UIRepairTask>>() {
        public void apply(final IPagedResult<UIRepairTask> it) {
          getView().showResults(it);
          getView().resetDirty();
          
        }
      };
    AsyncCallback<IPagedResult<UIRepairTask>> _onSuccess = this.<IPagedResult<UIRepairTask>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_dispatchRequestExecution(final RCRepairTaskProxy value) {
    
    RepairDispatchPresenter _get = this.repairDispatchPresenter.get();
    final Procedure1<RepairDispatchPresenter> _function = new Procedure1<RepairDispatchPresenter>() {
        public void apply(final RepairDispatchPresenter it) {
          final Procedure1<RepairDispatchPresenter> _function = new Procedure1<RepairDispatchPresenter>() {
              public void apply(final RepairDispatchPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup(value, _function);
        }
      };
    ObjectExtensions.<RepairDispatchPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_closeRepairTaskRequestExecution(final RCRepairTaskProxy value) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.RepairTasksChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.close(value, _onSuccess);
  }
  
  public void view_showRepairTaskDetailRequestExecution(final RCRepairTaskProxy value) {
    
    this.repairTaskInfoPresenter.setRepairTask(value);
  }
  
  public void _eventbus_RepairTasksChanged() {
    getView().refresh();
    
  }
  
  public void _eventbus_RepairTaskCreated(final RCRepairTaskProxy value) {
    
    getView().refreshNew(value);
    
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
    getView().modifyRequest(new RequestHandler1<RCRepairTaskProxy>(){
    			
    			public void execute(RCRepairTaskProxy value){
    				view_modifyRequestExecution(value);
    			}
    			
    		});
    getView().deleteRequest(new RequestHandler1<RCRepairTaskProxy>(){
    			
    			public void execute(RCRepairTaskProxy value){
    				view_deleteRequestExecution(value);
    			}
    			
    		});
    getView().cancelRequest(new RequestHandler1<RCRepairTaskProxy>(){
    			
    			public void execute(RCRepairTaskProxy value){
    				view_cancelRequestExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UIRepairTaskCriteria>(){
    			
    			public void execute(UIRepairTaskCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().dispatchRequest(new RequestHandler1<RCRepairTaskProxy>(){
    			
    			public void execute(RCRepairTaskProxy value){
    				view_dispatchRequestExecution(value);
    			}
    			
    		});
    getView().closeRepairTaskRequest(new RequestHandler1<RCRepairTaskProxy>(){
    			
    			public void execute(RCRepairTaskProxy value){
    				view_closeRepairTaskRequestExecution(value);
    			}
    			
    		});
    getView().showRepairTaskDetailRequest(new RequestHandler1<RCRepairTaskProxy>(){
    			
    			public void execute(RCRepairTaskProxy value){
    				view_showRepairTaskDetailRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.RepairTasksChangedEvent.__type__, new com.fudanmed.platform.core.web.client.project.RepairTasksChangedHandler(){
    public void RepairTasksChanged(){
    	_eventbus_RepairTasksChanged();
    }
    }));
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.RepairTaskCreatedEvent.__type__, new com.fudanmed.platform.core.web.client.project.RepairTaskCreatedHandler(){
    public void RepairTaskCreated(com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy value){
    	_eventbus_RepairTaskCreated(value);
    }
    }));
    
  }
}
