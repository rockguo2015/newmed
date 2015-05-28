package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairTaskPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairTaskPresenterView;
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
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateOrUpdateRepairTaskPresenter extends WorkbenchAbstractPresenter<CreateOrUpdateRepairTaskPresenterView> implements CommitablePresenter {
  @Inject
  protected CreateOrUpdateRepairTaskPresenterServiceAsync _service;
  
  @Inject
  public CreateOrUpdateRepairTaskPresenter(final CreateOrUpdateRepairTaskPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  private boolean used4Update;
  
  public OrganizationOutlinePresenter initPart(final OrganizationOutlinePresenter part) {
    this.registerPart(part);
    this.getView().setOrganizationOutlinePresenter(part);
    return part;
    
  }
  
  @Inject
  private OrganizationOutlinePresenter organizationOutlinePresenter;
  
  public void setup4Create(final IPresenterInitiazerNotifier<CreateOrUpdateRepairTaskPresenter> _notifier) {
    
    this.used4Update = false;
    OrganizationOutlinePresenter _initPart = this.initPart(this.organizationOutlinePresenter);
    final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
        public void apply(final OrganizationOutlinePresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                final Procedure1<RCEmployeeProxy> _function = new Procedure1<RCEmployeeProxy>() {
                    public void apply(final RCEmployeeProxy it) {
                      getView().setDefaultValues(it);
                      _notifier.done(CreateOrUpdateRepairTaskPresenter.this);
                    }
                  };
                AsyncCallback<RCEmployeeProxy> _onSuccess = CreateOrUpdateRepairTaskPresenter.this.<RCEmployeeProxy>onSuccess(_function);
                _service.getSystemUser(_onSuccess);
              }
            };
          CreateOrUpdateRepairTaskPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setupAsSimpleTree(_function);
  }
  
  public void setup4Update(final RCRepairTaskProxy value, final IPresenterInitiazerNotifier<CreateOrUpdateRepairTaskPresenter> _notifier) {
    
    this.used4Update = true;
    OrganizationOutlinePresenter _initPart = this.initPart(this.organizationOutlinePresenter);
    final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
        public void apply(final OrganizationOutlinePresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                final Procedure1<UIRepairTask> _function = new Procedure1<UIRepairTask>() {
                    public void apply(final UIRepairTask v) {
                      final Procedure1<OrgRelatedInfoData> _function = new Procedure1<OrgRelatedInfoData>() {
                          public void apply(final OrgRelatedInfoData it) {
                            Collection<UIOnsitePosition> _pos = it.getPos();
                            
                            Collection<UIEmployee> _workers = it.getWorkers();
                            
                            Collection<UIRepairTask> _historyTasks = it.getHistoryTasks();
                            getView().showOrgRelatedInfo(_pos,_workers,_historyTasks);
                            
                            CreateOrUpdateRepairTaskPresenterView _view = CreateOrUpdateRepairTaskPresenter.this.getView();
                            _view.setValue(v);_notifier.done(CreateOrUpdateRepairTaskPresenter.this);
                          }
                        };
                      AsyncCallback<OrgRelatedInfoData> _onSuccess = CreateOrUpdateRepairTaskPresenter.this.<OrgRelatedInfoData>onSuccess(_function);
                      _service.loadOrgRelatedInfoData4Task(value, _onSuccess);
                    }
                  };
                AsyncCallback<UIRepairTask> _onSuccess = CreateOrUpdateRepairTaskPresenter.this.<UIRepairTask>onSuccess(_function);
                _service.loadValue(value, _onSuccess);
              }
            };
          CreateOrUpdateRepairTaskPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setupAsSimpleTree(_function);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    if (this.used4Update) {
      CreateOrUpdateRepairTaskPresenterView _view = this.getView();
      UIRepairTask _value = _view.getValue();
      final Procedure1<Void> _function = new Procedure1<Void>() {
          public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.RepairTasksChangedEvent());
            
            notifier.success();
          }
        };
      AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
      _service.updateValue(_value, _onSuccess);
    } else {
      CreateOrUpdateRepairTaskPresenterView _view_1 = this.getView();
      UIRepairTask _value_1 = _view_1.getValue();
      final Procedure1<RCRepairTaskProxy> _function_1 = new Procedure1<RCRepairTaskProxy>() {
          public void apply(final RCRepairTaskProxy it) {
            eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.RepairTaskCreatedEvent(it));
            
            notifier.success();
          }
        };
      AsyncCallback<RCRepairTaskProxy> _onSuccess_1 = this.<RCRepairTaskProxy>onSuccess(_function_1);
      _service.createValue(_value_1, _onSuccess_1);
    }
  }
  
  public void view_organizationSelectedExecution(final RCOrganizationProxy org) {
    
    final Procedure1<OrgRelatedInfoData> _function = new Procedure1<OrgRelatedInfoData>() {
        public void apply(final OrgRelatedInfoData it) {
          Collection<UIOnsitePosition> _pos = it.getPos();
          
          Collection<UIEmployee> _workers = it.getWorkers();
          
          Collection<UIRepairTask> _historyTasks = it.getHistoryTasks();
          getView().showOrgRelatedInfo(_pos,_workers,_historyTasks);
          
        }
      };
    AsyncCallback<OrgRelatedInfoData> _onSuccess = this.<OrgRelatedInfoData>onSuccess(_function);
    _service.loadOrgRelatedInfoData(org, _onSuccess);
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
    getView().organizationSelected(new RequestHandler1<RCOrganizationProxy>(){
    			
    			public void execute(RCOrganizationProxy org){
    				view_organizationSelectedExecution(org);
    			}
    			
    		});
    getView().locationSelected(new RequestHandler1<RCOnsitePositionProxy>(){
    			
    			public void execute(RCOnsitePositionProxy loc){
    				view_locationSelectedExecution(loc);
    			}
    			
    		});
    
  }
}
