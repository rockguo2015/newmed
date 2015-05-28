package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateSettlementPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenter;
import com.fudanmed.platform.core.web.client.project.SettlementListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.SettlementListPresenterView;
import com.fudanmed.platform.core.web.client.project.SettlementSelectorPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListPresenter;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.fudanmed.platform.core.web.shared.project.UISettlementCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.client.common.print.Print;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SettlementListPresenter extends WorkbenchAbstractPresenter<SettlementListPresenterView> {
  @Inject
  protected SettlementListPresenterServiceAsync _service;
  
  @Inject
  public SettlementListPresenter(final SettlementListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateSettlementPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<SettlementSelectorPresenter> settlementSelectorPresenter;
  
  @Inject
  private Provider<RepairTaskTreeInfoPresenter> repairTaskInfoPresenter;
  
  public WorkItemStorage4SettlementListPresenter initPart(final WorkItemStorage4SettlementListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemStorage4SettlementListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemStorage4SettlementListPresenter workItemStorage4SettlementListPresenter;
  
  public void setup(final Procedure1<? super SettlementListPresenter> postInit) {
    
    WorkItemStorage4SettlementListPresenter _initPart = this.initPart(this.workItemStorage4SettlementListPresenter);
    final Procedure1<WorkItemStorage4SettlementListPresenter> _function = new Procedure1<WorkItemStorage4SettlementListPresenter>() {
        public void apply(final WorkItemStorage4SettlementListPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {getView().refresh();
                
                postInit.apply(SettlementListPresenter.this);
              }
            };
          SettlementListPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(_function);
  }
  
  public void view_filterRequestExecution(final UISettlementCriteria c) {
    
    final Procedure1<IPagedResult<UISettlement>> _function = new Procedure1<IPagedResult<UISettlement>>() {
        public void apply(final IPagedResult<UISettlement> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UISettlement>> _onSuccess = this.<IPagedResult<UISettlement>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_showDetailRequestExecution(final RCSettlementProxy value) {
    
    final Procedure1<Collection<UIRepairTask>> _function = new Procedure1<Collection<UIRepairTask>>() {
        public void apply(final Collection<UIRepairTask> it) {
          getView().showDetails(it);
          
          SettlementListPresenter.this.workItemStorage4SettlementListPresenter.setSettlement(value);
        }
      };
    AsyncCallback<Collection<UIRepairTask>> _onSuccess = this.<Collection<UIRepairTask>>onSuccess(_function);
    _service.loadDetails(value, _onSuccess);
  }
  
  public void _eventbus_SettlementsChanged() {
    getView().refresh();
    
  }
  
  public void view_createSettlementRequestExecution() {
    
    CreateOrUpdateSettlementPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateSettlementPresenter> _function = new Procedure1<CreateOrUpdateSettlementPresenter>() {
        public void apply(final CreateOrUpdateSettlementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup4Create(_function);
  }
  
  public void view_modifySettlementRequestExecution(final RCSettlementProxy settlement) {
    
    CreateOrUpdateSettlementPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateSettlementPresenter> _function = new Procedure1<CreateOrUpdateSettlementPresenter>() {
        public void apply(final CreateOrUpdateSettlementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup4Update(settlement, _function);
  }
  
  public void view_addRepairTaskItemsRequestExecution(final RCSettlementProxy settlement) {
    
    SettlementSelectorPresenter _get = this.settlementSelectorPresenter.get();
    final Procedure1<SettlementSelectorPresenter> _function = new Procedure1<SettlementSelectorPresenter>() {
        public void apply(final SettlementSelectorPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup(settlement, _function);
  }
  
  public void view_printSettlementRequestExecution(final RCSettlementProxy settlement) {
    
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String html) {
          Print.it(html);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.generatePrintContents(settlement, _onSuccess);
  }
  
  public void view_cancelSettlementItemRequestExecution(final Collection<RCRepairTaskProxy> repairTasks) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.cancelSettlementItems(repairTasks, _onSuccess);
  }
  
  public void view_showRepairTaskDetailExecution(final RCRepairTaskProxy repairTask) {
    
    RepairTaskTreeInfoPresenter _get = this.repairTaskInfoPresenter.get();
    final Procedure1<RepairTaskTreeInfoPresenter> _function = new Procedure1<RepairTaskTreeInfoPresenter>() {
        public void apply(final RepairTaskTreeInfoPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
          it.setRepairTask(repairTask);
        }
      };
    _get.setup(_function);
  }
  
  public void view_cancelSettlementRequestExecution(final RCSettlementProxy settlement) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {getView().refresh();
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function);
    _service.delete(settlement, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UISettlementCriteria>(){
    			
    			public void execute(UISettlementCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    getView().showDetailRequest(new RequestHandler1<RCSettlementProxy>(){
    			
    			public void execute(RCSettlementProxy value){
    				view_showDetailRequestExecution(value);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.SettlementsChangedEvent.__type__, new com.fudanmed.platform.core.web.client.project.SettlementsChangedHandler(){
    public void SettlementsChanged(){
    	_eventbus_SettlementsChanged();
    }
    }));
    getView().createSettlementRequest(new RequestHandler(){
    			
    			public void execute(){
    				view_createSettlementRequestExecution();
    			}
    			
    		});
    getView().modifySettlementRequest(new RequestHandler1<RCSettlementProxy>(){
    			
    			public void execute(RCSettlementProxy settlement){
    				view_modifySettlementRequestExecution(settlement);
    			}
    			
    		});
    getView().addRepairTaskItemsRequest(new RequestHandler1<RCSettlementProxy>(){
    			
    			public void execute(RCSettlementProxy settlement){
    				view_addRepairTaskItemsRequestExecution(settlement);
    			}
    			
    		});
    getView().printSettlementRequest(new RequestHandler1<RCSettlementProxy>(){
    			
    			public void execute(RCSettlementProxy settlement){
    				view_printSettlementRequestExecution(settlement);
    			}
    			
    		});
    getView().cancelSettlementItemRequest(new RequestHandler1<Collection<RCRepairTaskProxy>>(){
    			
    			public void execute(Collection<RCRepairTaskProxy> repairTasks){
    				view_cancelSettlementItemRequestExecution(repairTasks);
    			}
    			
    		});
    getView().showRepairTaskDetail(new RequestHandler1<RCRepairTaskProxy>(){
    			
    			public void execute(RCRepairTaskProxy repairTask){
    				view_showRepairTaskDetailExecution(repairTask);
    			}
    			
    		});
    getView().cancelSettlementRequest(new RequestHandler1<RCSettlementProxy>(){
    			
    			public void execute(RCSettlementProxy settlement){
    				view_cancelSettlementRequestExecution(settlement);
    			}
    			
    		});
    
  }
}
