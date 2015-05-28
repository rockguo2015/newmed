package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatisticListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatisticListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatisticData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairTaskStatisticListPresenter extends WorkbenchAbstractPresenter<RepairTaskStatisticListPresenterView> {
  @Inject
  protected RepairTaskStatisticListPresenterServiceAsync _service;
  
  @Inject
  public RepairTaskStatisticListPresenter(final RepairTaskStatisticListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<RepairTaskStatisticListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(RepairTaskStatisticListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void view_teamChangedExecution(final RCMaintenanceTeamProxy newTeam) {
    
    final Procedure1<RCOrganizationProxy> _function = new Procedure1<RCOrganizationProxy>() {
        public void apply(final RCOrganizationProxy it) {
          RepairTaskStatisticListPresenterView _view = RepairTaskStatisticListPresenter.this.getView();
          _view.setSelectedOrganization(it);
        }
      };
    AsyncCallback<RCOrganizationProxy> _onSuccess = this.<RCOrganizationProxy>onSuccess(_function);
    _service.loadOrganization(newTeam, _onSuccess);
  }
  
  public void refresh() {
    
    RepairTaskStatisticListPresenterView _view = this.getView();
    _view.refresh();
  }
  
  public void view_queryRequestExecution(final UIRepairTaskStatisticCriteria c) {
    
    final Procedure1<Collection<UIRepairTaskStatisticData>> _function = new Procedure1<Collection<UIRepairTaskStatisticData>>() {
        public void apply(final Collection<UIRepairTaskStatisticData> it) {
          RepairTaskStatisticListPresenterView _view = RepairTaskStatisticListPresenter.this.getView();
          _view.setResults(it);
        }
      };
    AsyncCallback<Collection<UIRepairTaskStatisticData>> _onSuccess = this.<Collection<UIRepairTaskStatisticData>>onSuccess(_function);
    _service.loadRepairTaskList(c, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().teamChanged(new RequestHandler1<RCMaintenanceTeamProxy>(){
    			
    			public void execute(RCMaintenanceTeamProxy newTeam){
    				view_teamChangedExecution(newTeam);
    			}
    			
    		});
    getView().queryRequest(new RequestHandler1<UIRepairTaskStatisticCriteria>(){
    			
    			public void execute(UIRepairTaskStatisticCriteria c){
    				view_queryRequestExecution(c);
    			}
    			
    		});
    
  }
}
