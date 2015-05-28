package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateWorkItemTaskPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateWorkItemTaskPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.google.common.base.Objects;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.extensions.ConfigurableAsyncCallback;
import com.uniquesoft.gwt.client.common.print.Print;
import com.uniquesoft.gwt.shared.extensions.BooleanExtensions;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateWorkItemTaskPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateWorkItemTaskPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateWorkItemTaskPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateWorkItemTaskPresenter(final CreateOrUpdateWorkItemTaskPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  private RCGroupTaskProxy groupTask;
  
  public void setup4Create(final RCGroupTaskProxy groupTask, final Procedure1<? super CreateOrUpdateWorkItemTaskPresenter> postInitializer) {
    
    this.used4Update = false;
    this.groupTask = groupTask;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
              public void apply(final UIRepairTask repairTask) {
                boolean _equals = Objects.equal(repairTask, null);
                if (_equals) {
                  Info.display("\u9519\u8BEF", "\u65E0\u6CD5\u6D3E\u5DE5\uFF0C\u8BF7\u5237\u65B0\u786E\u8BA4\u62A5\u4FEE\u72B6\u6001");
                } else {
                  final Procedure1<RCOrganizationProxy> _function = new Procedure1<RCOrganizationProxy>() {
                      public void apply(final RCOrganizationProxy teams) {
                        final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
                            public void apply(final RCEmployeeProxy user) {
                              
                              UIFaultType _faultType = repairTask.getFaultType();
                              RCFaultTypeProxy _proxy = _faultType.toProxy();
                              
                              String _comment = repairTask.getComment();
                              
                              
                              final Procedure1<Void> _function = new Procedure1<Void>() {
                                  public void apply(final Void m) {
                                    postInitializer.apply(CreateOrUpdateWorkItemTaskPresenter.this);
                                  }
                                };
                              getView().setDefaultValues(user,_proxy,_comment,teams,_function);
                              
                            }
                          };
                        AsyncCallback<RCEmployeeProxy> _onSuccess = CreateOrUpdateWorkItemTaskPresenter.this.<RCEmployeeProxy>onSuccess(_function);
                        _service.loadSystemUser(_onSuccess);
                      }
                    };
                  AsyncCallback<RCOrganizationProxy> _onSuccess = CreateOrUpdateWorkItemTaskPresenter.this.<RCOrganizationProxy>onSuccess(_function);
                  _service.loadTeam(groupTask, _onSuccess);
                }
              }
            };
          AsyncCallback<UIRepairTask> _onSuccess = CreateOrUpdateWorkItemTaskPresenter.this.<UIRepairTask>onSuccess(_function);
          _service.loadRepairTask(groupTask, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCWorkItemTaskProxy value, final Procedure1<? super CreateOrUpdateWorkItemTaskPresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCOrganizationProxy> _function = new Procedure1<RCOrganizationProxy>() {
              public void apply(final RCOrganizationProxy team) {
                
                
                
                
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void m) {
                      final Procedure1<UIWorkItemTask> _function = new Procedure1<UIWorkItemTask>() {
                          public void apply(final UIWorkItemTask it) {
                            CreateOrUpdateWorkItemTaskPresenterView _view = CreateOrUpdateWorkItemTaskPresenter.this.getView();
                            _view.setValue(it);
                            postInitializer.apply(CreateOrUpdateWorkItemTaskPresenter.this);
                          }
                        };
                      AsyncCallback<UIWorkItemTask> _onSuccess = CreateOrUpdateWorkItemTaskPresenter.this.<UIWorkItemTask>onSuccess(_function);
                      _service.loadValue(value, _onSuccess);
                    }
                  };
                getView().setDefaultValues(null,null,null,team,_function);
                
              }
            };
          AsyncCallback<RCOrganizationProxy> _onSuccess = CreateOrUpdateWorkItemTaskPresenter.this.<RCOrganizationProxy>onSuccess(_function);
          _service.loadTeam(CreateOrUpdateWorkItemTaskPresenter.this.groupTask, _onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdateWorkItemTaskPresenterView _view = this.getView();
      UIWorkItemTask _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.GroupTasksChangedEvent());
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.WorkItemTasksChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateWorkItemTaskPresenterView _view_1 = this.getView();
      UIWorkItemTask _value_1 = _view_1.getValue();
      final Procedure1<ConfigurableAsyncCallback<RCWorkItemTaskProxy>> _function_1 = new Procedure1<ConfigurableAsyncCallback<RCWorkItemTaskProxy>>() {
          public void apply(final ConfigurableAsyncCallback<RCWorkItemTaskProxy> it) {
            final Procedure1<RCWorkItemTaskProxy> _function = new Procedure1<RCWorkItemTaskProxy>() {
                public void apply(final RCWorkItemTaskProxy workItemTask) {
                  CreateOrUpdateWorkItemTaskPresenterView _view = CreateOrUpdateWorkItemTaskPresenter.this.getView();
                  UIWorkItemTask _value = _view.getValue();
                  Boolean _print = _value.getPrint();
                  boolean _isLogicTrue = BooleanExtensions.isLogicTrue(_print);
                  if (_isLogicTrue) {
                    final Procedure1<String> _function = new Procedure1<String>() {
                        public void apply(final String html) {
                          Print.it(html);
                        }
                      };
                    AsyncCallback<String> _onSuccess = CreateOrUpdateWorkItemTaskPresenter.this.<String>onSuccess(_function);
                    _service.generatePrintContents(workItemTask, _onSuccess);
                  }eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.GroupTasksChangedEvent());
                  eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.WorkItemTasksChangedEvent());
                  
                  notifier.success();
                }
              };
            it.onSuccessDo(_function);
            final Procedure1<Throwable> _function_1 = new Procedure1<Throwable>() {
                public void apply(final Throwable it) {
                  Info.display("\u9519\u8BEF", "\u65E0\u6CD5\u6D3E\u5DE5\uFF0C\u8BF7\u5237\u65B0\u786E\u8BA4\u62A5\u4FEE\u72B6\u6001");
                }
              };
            it.onFailureDo(_function_1);
          }
        };
      ConfigurableAsyncCallback<RCWorkItemTaskProxy> _callback = ConfigurableAsyncCallback.<RCWorkItemTaskProxy>callback(_function_1);
      _service.createValue(this.groupTask, _value_1, _callback);
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
