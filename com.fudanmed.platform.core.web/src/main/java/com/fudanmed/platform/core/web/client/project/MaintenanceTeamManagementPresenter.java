package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.MaintenanceTeamManagementPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIMaintenanceTeam;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class MaintenanceTeamManagementPresenter extends WorkbenchAbstractPresenter<MaintenanceTeamManagementPresenterView> {
  @Inject
  protected MaintenanceTeamManagementPresenterServiceAsync _service;
  
  @Inject
  public MaintenanceTeamManagementPresenter(final MaintenanceTeamManagementPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private OrganizationOutlinePresenter organizationOutlinePresenter;
  
  public void setup(final Procedure1<? super MaintenanceTeamManagementPresenter> postInit) {
    
    final Procedure1<OrganizationOutlinePresenter> _function = new Procedure1<OrganizationOutlinePresenter>() {
        public void apply(final OrganizationOutlinePresenter it) {
          getView().setOrganizationOutlinePresenter(it);
          
          MaintenanceTeamManagementPresenter.this.registerPart(it);
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                MaintenanceTeamManagementPresenter.this.refresh();
                postInit.apply(MaintenanceTeamManagementPresenter.this);
              }
            };
          MaintenanceTeamManagementPresenter.this.activate(new IPostInitializeAction() {
              public void initializeFinished(Void v) {
                _function.apply(v);
              }
          });
        }
      };
    this.organizationOutlinePresenter.setupAsSimpleTree(_function);
  }
  
  public void view_selectAsTeamExecution(final RCOrganizationProxy org) {
    
    final Procedure1<RCMaintenanceTeamProxy> _function = new Procedure1<RCMaintenanceTeamProxy>() {
        public void apply(final RCMaintenanceTeamProxy team) {
          MaintenanceTeamManagementPresenter.this.refresh();
        }
      };
    AsyncCallback<RCMaintenanceTeamProxy> _onSuccess = this.<RCMaintenanceTeamProxy>onSuccess(_function);
    _service.selectAsTeam(org, _onSuccess);
  }
  
  public void view_removeFromTeamExecution(final RCMaintenanceTeamProxy team) {
    
    final Procedure1<RCOrganizationProxy> _function = new Procedure1<RCOrganizationProxy>() {
        public void apply(final RCOrganizationProxy org) {
          MaintenanceTeamManagementPresenter.this.refresh();
        }
      };
    AsyncCallback<RCOrganizationProxy> _onSuccess = this.<RCOrganizationProxy>onSuccess(_function);
    _service.removeFromTeam(team, _onSuccess);
  }
  
  public void refresh() {
    
    final Procedure1<Collection<UIMaintenanceTeam>> _function = new Procedure1<Collection<UIMaintenanceTeam>>() {
        public void apply(final Collection<UIMaintenanceTeam> it) {
          getView().showTeams(it);
          
        }
      };
    AsyncCallback<Collection<UIMaintenanceTeam>> _onSuccess = this.<Collection<UIMaintenanceTeam>>onSuccess(_function);
    _service.loadTeams(_onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().selectAsTeam(new RequestHandler1<RCOrganizationProxy>(){
    			
    			public void execute(RCOrganizationProxy org){
    				view_selectAsTeamExecution(org);
    			}
    			
    		});
    getView().removeFromTeam(new RequestHandler1<RCMaintenanceTeamProxy>(){
    			
    			public void execute(RCMaintenanceTeamProxy team){
    				view_removeFromTeamExecution(team);
    			}
    			
    		});
    
  }
}
