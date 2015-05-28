package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateReportPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateReportPresenterView;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.fudanmed.platform.core.web.shared.project.OrgRelatedInfoData;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateReportPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateReportPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateReportPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateReportPresenter(final CreateOrUpdateReportPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public void setup4Create(final Procedure1<? super CreateOrUpdateReportPresenter> postInitializer) {
    
    this.used4Update = false;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<RCOrganizationProxy> _function = new Procedure1<RCOrganizationProxy>() {
              public void apply(final RCOrganizationProxy it) {
                getView().setReportOrg(it);
                
                final Procedure1<OrgRelatedInfoData> _function = new Procedure1<OrgRelatedInfoData>() {
                    public void apply(final OrgRelatedInfoData orgRelInfo) {
                      Collection<UIOnsitePosition> _pos = orgRelInfo.getPos();
                      
                      Collection<UIEmployee> _workers = orgRelInfo.getWorkers();
                      
                      Collection<UIRepairTask> _historyTasks = orgRelInfo.getHistoryTasks();
                      getView().showOrgRelatedInfo(_pos,_workers,_historyTasks);
                      
                      final Procedure1<Collection<String>> _function = new Procedure1<Collection<String>>() {
                          public void apply(final Collection<String> it) {
                            getView().showHistoryReportContents(it);
                            
                            final Procedure1<UIEmployee> _function = new Procedure1<UIEmployee>() {
                                public void apply(final UIEmployee it) {
                                  getView().setDefaultReporter(it);
                                  
                                  postInitializer.apply(CreateOrUpdateReportPresenter.this);
                                }
                              };
                            AsyncCallback<UIEmployee> _onSuccess = CreateOrUpdateReportPresenter.this.<UIEmployee>onSuccess(_function);
                            _service.getReporter(_onSuccess);
                          }
                        };
                      AsyncCallback<Collection<String>> _onSuccess = CreateOrUpdateReportPresenter.this.<Collection<String>>onSuccess(_function);
                      _service.getLastReportContents(_onSuccess);
                    }
                  };
                AsyncCallback<OrgRelatedInfoData> _onSuccess = CreateOrUpdateReportPresenter.this.<OrgRelatedInfoData>onSuccess(_function);
                _service.loadOrgRelatedInfoData(it, _onSuccess);
              }
            };
          AsyncCallback<RCOrganizationProxy> _onSuccess = CreateOrUpdateReportPresenter.this.<RCOrganizationProxy>onSuccess(_function);
          _service.getReportOrg(_onSuccess);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setup4Update(final RCRepairTaskProxy value, final Procedure1<? super CreateOrUpdateReportPresenter> postInitializer) {
    
    this.used4Update = true;
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
              public void apply(final UIRepairTask it) {
                CreateOrUpdateReportPresenterView _view = CreateOrUpdateReportPresenter.this.getView();
                _view.setValue(it);
                postInitializer.apply(CreateOrUpdateReportPresenter.this);
              }
            };
          AsyncCallback<UIRepairTask> _onSuccess = CreateOrUpdateReportPresenter.this.<UIRepairTask>onSuccess(_function);
          _service.loadValue(value, _onSuccess);
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
      CreateOrUpdateReportPresenterView _view = this.getView();
      UIRepairTask _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.RepairTasksChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateReportPresenterView _view_1 = this.getView();
      UIRepairTask _value_1 = _view_1.getValue();
      final Procedure1<Void> _function_1 = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.RepairTasksChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess_1 = this.<Void>onSuccess(_function_1);
      _service.createValue(_value_1, _onSuccess_1);
    }
  }
  
  public void view_locationSelectedExecution(final RCOnsitePositionProxy loc) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          getView().setLocation(it);
          
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.getFullPath(loc, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().locationSelected(new RequestHandler1<RCOnsitePositionProxy>(){
    			
    			public void execute(RCOnsitePositionProxy loc){
    				view_locationSelectedExecution(loc);
    			}
    			
    		});
    
  }
}
