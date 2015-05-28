package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateComplaintPresenter;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateRepairEvaluatePresenter;
import com.fudanmed.platform.core.web.client.project.CreateOrUpdateReportPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskTreeInfoPresenter;
import com.fudanmed.platform.core.web.client.project.ReportManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.ReportManagementPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.fudanmed.platform.core.web.shared.project.UIReportCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ReportManagementPresenter extends WorkbenchAbstractPresenter<ReportManagementPresenterView> {
  @Inject
  protected ReportManagementPresenterServiceAsync _service;
  
  @Inject
  public ReportManagementPresenter(final ReportManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private Provider<CreateOrUpdateReportPresenter> createOrUpdatePresenter;
  
  @Inject
  private Provider<CreateOrUpdateComplaintPresenter> createOrUpdateComplaintPresenter;
  
  @Inject
  private Provider<CreateOrUpdateRepairEvaluatePresenter> createOrUpdateRepairEvaluatePresenter;
  
  public RepairTaskTreeInfoPresenter initPart(final RepairTaskTreeInfoPresenter part) {
    this.registerPart(part);
    this.getView().setRepairTaskInfoPresenter(part);
    return part;
    
  }
  
  @Inject
  private RepairTaskTreeInfoPresenter repairTaskInfoPresenter;
  
  public void setup(final Procedure1<? super ReportManagementPresenter> postInit) {
    
    RepairTaskTreeInfoPresenter _initPart = this.initPart(this.repairTaskInfoPresenter);
    final Procedure1<RepairTaskTreeInfoPresenter> _function = new Procedure1<RepairTaskTreeInfoPresenter>() {
        public void apply(final RepairTaskTreeInfoPresenter it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {getView().refresh();
                
                postInit.apply(ReportManagementPresenter.this);
              }
            };
          ReportManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    _initPart.setup(_function);
  }
  
  public void view_createRequestExecution() {
    
    CreateOrUpdateReportPresenter _get = this.createOrUpdatePresenter.get();
    final Procedure1<CreateOrUpdateReportPresenter> _function = new Procedure1<CreateOrUpdateReportPresenter>() {
        public void apply(final CreateOrUpdateReportPresenter it) {
          final Procedure1<CreateOrUpdateReportPresenter> _function = new Procedure1<CreateOrUpdateReportPresenter>() {
              public void apply(final CreateOrUpdateReportPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(_function);
        }
      };
    ObjectExtensions.<CreateOrUpdateReportPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_complaintRequestExecution(final RCRepairTaskProxy value) {
    
    CreateOrUpdateComplaintPresenter _get = this.createOrUpdateComplaintPresenter.get();
    final Procedure1<CreateOrUpdateComplaintPresenter> _function = new Procedure1<CreateOrUpdateComplaintPresenter>() {
        public void apply(final CreateOrUpdateComplaintPresenter it) {
          final Procedure1<CreateOrUpdateComplaintPresenter> _function = new Procedure1<CreateOrUpdateComplaintPresenter>() {
              public void apply(final CreateOrUpdateComplaintPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          it.setup4Create(value, _function);
        }
      };
    ObjectExtensions.<CreateOrUpdateComplaintPresenter>operator_doubleArrow(_get, _function);
  }
  
  public void view_filterRequestExecution(final UIReportCriteria c) {
    
    final Procedure1<IPagedResult<UIRepairTask>> _function = new Procedure1<IPagedResult<UIRepairTask>>() {
        public void apply(final IPagedResult<UIRepairTask> it) {
          getView().showResults(it);
          
        }
      };
    AsyncCallback<IPagedResult<UIRepairTask>> _onSuccess = this.<IPagedResult<UIRepairTask>>onSuccess(_function);
    _service.filter(c, _onSuccess);
  }
  
  public void view_showRepairTaskDetailRequestExecution(final RCRepairTaskProxy value) {
    
    this.repairTaskInfoPresenter.setRepairTask(value);
  }
  
  public void _eventbus_RepairTasksChanged() {
    getView().refresh();
    
  }
  
  public void _eventbus_RepairEvaluatesChanged() {
    getView().refresh();
    
  }
  
  public void view_doEvaluateExecution(final RCRepairTaskProxy value) {
    
    final Procedure1<RCRepairEvaluateProxy> _function = new Procedure1<RCRepairEvaluateProxy>() {
        public void apply(final RCRepairEvaluateProxy it) {
          CreateOrUpdateRepairEvaluatePresenter _get = ReportManagementPresenter.this.createOrUpdateRepairEvaluatePresenter.get();
          final Procedure1<CreateOrUpdateRepairEvaluatePresenter> _function = new Procedure1<CreateOrUpdateRepairEvaluatePresenter>() {
              public void apply(final CreateOrUpdateRepairEvaluatePresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
                
              }
            };
          _get.setup4Update(it, _function);
        }
      };
    AsyncCallback<RCRepairEvaluateProxy> _onSuccess = this.<RCRepairEvaluateProxy>onSuccess(_function);
    _service.loadRepairEvaluate(value, _onSuccess);
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
    getView().complaintRequest(new RequestHandler1<RCRepairTaskProxy>(){
    			
    			public void execute(RCRepairTaskProxy value){
    				view_complaintRequestExecution(value);
    			}
    			
    		});
    getView().filterRequest(new RequestHandler1<UIReportCriteria>(){
    			
    			public void execute(UIReportCriteria c){
    				view_filterRequestExecution(c);
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
    _regs_.add(eventBus.addHandler(com.fudanmed.platform.core.web.client.project.RepairEvaluatesChangedEvent.__type__, new com.fudanmed.platform.core.web.client.project.RepairEvaluatesChangedHandler(){
    public void RepairEvaluatesChanged(){
    	_eventbus_RepairEvaluatesChanged();
    }
    }));
    getView().doEvaluate(new RequestHandler1<RCRepairTaskProxy>(){
    			
    			public void execute(RCRepairTaskProxy value){
    				view_doEvaluateExecution(value);
    			}
    			
    		});
    
  }
}
