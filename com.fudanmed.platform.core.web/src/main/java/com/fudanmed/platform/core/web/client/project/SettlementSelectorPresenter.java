package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenter;
import com.fudanmed.platform.core.web.client.project.SettlementSelectorPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.SettlementSelectorPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask4SettlementCriteria;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.CommitResultNotifier;
import com.uniquesoft.gwt.client.common.CommitablePresenter;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.extensions.IterableExtensions2;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class SettlementSelectorPresenter extends WorkbenchAbstractPresenter<SettlementSelectorPresenterView> implements CommitablePresenter {
  @Inject
  protected SettlementSelectorPresenterServiceAsync _service;
  
  @Inject
  public SettlementSelectorPresenter(final SettlementSelectorPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public RepairTaskTreeInfoPresenter initPart(final RepairTaskTreeInfoPresenter part) {
    this.registerPart(part);
    this.getView().setRepairTaskInfoPresenter(part);
    return part;
    
  }
  
  @Inject
  private RepairTaskTreeInfoPresenter repairTaskInfoPresenter;
  
  private RCSettlementProxy settlement;
  
  public void setup(final RCSettlementProxy settlement, final Procedure1<? super SettlementSelectorPresenter> postInit) {
    
    this.settlement = settlement;
    RepairTaskTreeInfoPresenter _initPart = this.initPart(this.repairTaskInfoPresenter);
    final Procedure1<RepairTaskTreeInfoPresenter> _function = new Procedure1<RepairTaskTreeInfoPresenter>() {
        public void apply(final RepairTaskTreeInfoPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                final Procedure1<UISettlement> _function = new Procedure1<UISettlement>() {
                    public void apply(final UISettlement it) {
                      SettlementSelectorPresenterView _view = SettlementSelectorPresenter.this.getView();
                      Date _fromDate = it.getFromDate();
                      Date _toDate = it.getToDate();
                      _view.setInitialDateRange(_fromDate, _toDate);
                      SettlementSelectorPresenterView _view_1 = SettlementSelectorPresenter.this.getView();
                      _view_1.refresh();
                      postInit.apply(SettlementSelectorPresenter.this);
                    }
                  };
                AsyncCallback<UISettlement> _onSuccess = SettlementSelectorPresenter.this.<UISettlement>onSuccess(_function);
                _service.loadSettlement(settlement, _onSuccess);
              }
            };
          SettlementSelectorPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(_function);
  }
  
  public void view_filterRequestExecution(final UIRepairTask4SettlementCriteria c) {
    
    final Procedure1<IPagedResult<UIRepairTask>> _function = new Procedure1<IPagedResult<UIRepairTask>>() {
        public void apply(final IPagedResult<UIRepairTask> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIRepairTask>> _onSuccess = this.<IPagedResult<UIRepairTask>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void _eventbus_RepairTasksChanged() {
    getView().refresh();
    
  }
  
  public void view_showTaskDetailRequestExecution(final RCRepairTaskProxy repairTask) {
    
    this.repairTaskInfoPresenter.setRepairTask(repairTask);
  }
  
  public void performCommit(final CommitResultNotifier notifier) {
    
    SettlementSelectorPresenterView _view = this.getView();
    Iterable<UIRepairTask> _selectedRepairTasks = _view.getSelectedRepairTasks();
    final Function1<UIRepairTask,RCRepairTaskProxy> _function = new Function1<UIRepairTask,RCRepairTaskProxy>() {
        public RCRepairTaskProxy apply(final UIRepairTask it) {
          RCRepairTaskProxy _proxy = it.toProxy();
          return _proxy;
        }
      };
    Iterable<RCRepairTaskProxy> _map = IterableExtensions.<UIRepairTask, RCRepairTaskProxy>map(_selectedRepairTasks, _function);
    Collection<RCRepairTaskProxy> _unlazy = IterableExtensions2.<RCRepairTaskProxy>unlazy(_map);
    final Procedure1<Void> _function_1 = new Procedure1<Void>() {
        public void apply(final Void it) {
          notifier.success();eventBus.fireEvent(new com.fudanmed.platform.core.web.client.project.SettlementsChangedEvent());
          
        }
      };
    AsyncCallback<Void> _onSuccess = this.<Void>onSuccess(_function_1);
    _service.performSettlement(this.settlement, _unlazy, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIRepairTask4SettlementCriteria>(){
    			
    			public void execute(UIRepairTask4SettlementCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.RepairTasksChangedEvent.__type__, new com.fudanmed.platform.core.web.client.project.RepairTasksChangedHandler(){
    public void RepairTasksChanged(){
    	_eventbus_RepairTasksChanged();
    }
    }));
    getView().showTaskDetailRequest(new RequestHandler1<RCRepairTaskProxy>(){
    			
    			public void execute(RCRepairTaskProxy repairTask){
    				view_showTaskDetailRequestExecution(repairTask);
    			}
    			
    		});
    
  }
}
