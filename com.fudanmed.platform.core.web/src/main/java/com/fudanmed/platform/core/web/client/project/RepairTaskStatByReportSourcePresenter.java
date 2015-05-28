package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamListPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeListPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListPresenter;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByReportSourcePresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByReportSourcePresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByReportSourceCriteriaData;
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

public class RepairTaskStatByReportSourcePresenter extends WorkbenchAbstractPresenter<RepairTaskStatByReportSourcePresenterView> {
  @Inject
  protected RepairTaskStatByReportSourcePresenterServiceAsync _service;
  
  @Inject
  public RepairTaskStatByReportSourcePresenter(final RepairTaskStatByReportSourcePresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public RepairTaskStatByFaultTypeListPresenter initPart(final RepairTaskStatByFaultTypeListPresenter part) {
    this.registerPart(part);
    this.getView().setRepairTaskStatByFaultTypeListPresenter(part);
    return part;
    
  }
  
  @Inject
  private RepairTaskStatByFaultTypeListPresenter repairTaskStatByFaultTypeListPresenter;
  
  public RepairTaskStatByOrganizationTypeListPresenter initPart(final RepairTaskStatByOrganizationTypeListPresenter part) {
    this.registerPart(part);
    this.getView().setRepairTaskStatByOrganizationTypeListPresenter(part);
    return part;
    
  }
  
  @Inject
  private RepairTaskStatByOrganizationTypeListPresenter repairTaskStatByOrganizationTypeListPresenter;
  
  public GroupTaskStatByTeamListPresenter initPart(final GroupTaskStatByTeamListPresenter part) {
    this.registerPart(part);
    this.getView().setGroupTaskStatByTeamListPresenter(part);
    return part;
    
  }
  
  @Inject
  private GroupTaskStatByTeamListPresenter groupTaskStatByTeamListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<RepairTaskStatByReportSourcePresenter> _notifier) {
    
    RepairTaskStatByFaultTypeListPresenter _initPart = this.initPart(this.repairTaskStatByFaultTypeListPresenter);
    final Procedure1<RepairTaskStatByFaultTypeListPresenter> _function = new Procedure1<RepairTaskStatByFaultTypeListPresenter>() {
        public void apply(final RepairTaskStatByFaultTypeListPresenter it) {
          RepairTaskStatByOrganizationTypeListPresenter _initPart = RepairTaskStatByReportSourcePresenter.this.initPart(RepairTaskStatByReportSourcePresenter.this.repairTaskStatByOrganizationTypeListPresenter);
          final Procedure1<RepairTaskStatByOrganizationTypeListPresenter> _function = new Procedure1<RepairTaskStatByOrganizationTypeListPresenter>() {
              public void apply(final RepairTaskStatByOrganizationTypeListPresenter it) {
                GroupTaskStatByTeamListPresenter _initPart = RepairTaskStatByReportSourcePresenter.this.initPart(RepairTaskStatByReportSourcePresenter.this.groupTaskStatByTeamListPresenter);
                final Procedure1<GroupTaskStatByTeamListPresenter> _function = new Procedure1<GroupTaskStatByTeamListPresenter>() {
                    public void apply(final GroupTaskStatByTeamListPresenter it) {
                      final Procedure1<Void> _function = new Procedure1<Void>() {
                          public void apply(final Void it) {
                            RepairTaskStatByReportSourcePresenterView _view = RepairTaskStatByReportSourcePresenter.this.getView();
                            _view.refresh();_notifier.done(RepairTaskStatByReportSourcePresenter.this);
                          }
                        };
                      RepairTaskStatByReportSourcePresenter.this.activate(new IPostInitializeAction() {
                          public void initializeFinished(Void v) {
                            _function.apply(v);
                          }
                      });
                    }
                  };
                _initPart.setup(new IPresenterInitiazerNotifier<GroupTaskStatByTeamListPresenter>() {
                    public void done(GroupTaskStatByTeamListPresenter presenter) {
                      _function.apply(presenter);
                    }
                });
              }
            };
          _initPart.setup(new IPresenterInitiazerNotifier<RepairTaskStatByOrganizationTypeListPresenter>() {
              public void done(RepairTaskStatByOrganizationTypeListPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<RepairTaskStatByFaultTypeListPresenter>() {
        public void done(RepairTaskStatByFaultTypeListPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIRepairTaskCriteria c) {
    
    final Procedure1<Collection<UIRepairTaskStatByReportSourceCriteriaData>> _function = new Procedure1<Collection<UIRepairTaskStatByReportSourceCriteriaData>>() {
        public void apply(final Collection<UIRepairTaskStatByReportSourceCriteriaData> it) {
          RepairTaskStatByReportSourcePresenterView _view = RepairTaskStatByReportSourcePresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIRepairTaskStatByReportSourceCriteriaData>> _onSuccess = this.<Collection<UIRepairTaskStatByReportSourceCriteriaData>>onSuccess(_function);
    _service.loadResult(c, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIRepairTaskCriteria>(){
    			
    			public void execute(UIRepairTaskCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    
  }
}
