package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamPresenterView;
import com.fudanmed.platform.core.web.client.project.WorkItemStockRecordItemStat4ProductEntryListPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemTask4WorkersStatListPresenter;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
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

public class GroupTaskStatByTeamPresenter extends WorkbenchAbstractPresenter<GroupTaskStatByTeamPresenterView> {
  @Inject
  protected GroupTaskStatByTeamPresenterServiceAsync _service;
  
  @Inject
  public GroupTaskStatByTeamPresenter(final GroupTaskStatByTeamPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public WorkItemTask4WorkersStatListPresenter initPart(final WorkItemTask4WorkersStatListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemTask4WorkersStatListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemTask4WorkersStatListPresenter workItemTask4WorkersStatListPresenter;
  
  public WorkItemStockRecordItemStat4ProductEntryListPresenter initPart(final WorkItemStockRecordItemStat4ProductEntryListPresenter part) {
    this.registerPart(part);
    this.getView().setWorkItemStockRecordItemStat4ProductEntryListPresenter(part);
    return part;
    
  }
  
  @Inject
  private WorkItemStockRecordItemStat4ProductEntryListPresenter workItemStockRecordItemStat4ProductEntryListPresenter;
  
  public void setup(final IPresenterInitiazerNotifier<GroupTaskStatByTeamPresenter> _notifier) {
    
    WorkItemTask4WorkersStatListPresenter _initPart = this.initPart(this.workItemTask4WorkersStatListPresenter);
    final Procedure1<WorkItemTask4WorkersStatListPresenter> _function = new Procedure1<WorkItemTask4WorkersStatListPresenter>() {
        public void apply(final WorkItemTask4WorkersStatListPresenter it) {
          WorkItemStockRecordItemStat4ProductEntryListPresenter _initPart = GroupTaskStatByTeamPresenter.this.initPart(GroupTaskStatByTeamPresenter.this.workItemStockRecordItemStat4ProductEntryListPresenter);
          final Procedure1<WorkItemStockRecordItemStat4ProductEntryListPresenter> _function = new Procedure1<WorkItemStockRecordItemStat4ProductEntryListPresenter>() {
              public void apply(final WorkItemStockRecordItemStat4ProductEntryListPresenter it) {
                final Procedure1<Void> _function = new Procedure1<Void>() {
                    public void apply(final Void it) {
                      GroupTaskStatByTeamPresenterView _view = GroupTaskStatByTeamPresenter.this.getView();
                      _view.refresh();_notifier.done(GroupTaskStatByTeamPresenter.this);
                    }
                  };
                GroupTaskStatByTeamPresenter.this.activate(new IPostInitializeAction() {
                    public void initializeFinished(Void v) {
                      _function.apply(v);
                    }
                });
              }
            };
          _initPart.setup(new IPresenterInitiazerNotifier<WorkItemStockRecordItemStat4ProductEntryListPresenter>() {
              public void done(WorkItemStockRecordItemStat4ProductEntryListPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    _initPart.setup(new IPresenterInitiazerNotifier<WorkItemTask4WorkersStatListPresenter>() {
        public void done(WorkItemTask4WorkersStatListPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public void view_filterRequestExecution(final UIGroupTaskCriteria c) {
    
    final Procedure1<Collection<UIGroupTaskStatByTeamCriteriaData>> _function = new Procedure1<Collection<UIGroupTaskStatByTeamCriteriaData>>() {
        public void apply(final Collection<UIGroupTaskStatByTeamCriteriaData> it) {
          GroupTaskStatByTeamPresenterView _view = GroupTaskStatByTeamPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIGroupTaskStatByTeamCriteriaData>> _onSuccess = this.<Collection<UIGroupTaskStatByTeamCriteriaData>>onSuccess(_function);
    _service.loadResult(c, _onSuccess);
  }
  
  private Collection<HandlerRegistration> _regs_ = com.google.common.collect.Lists.newArrayList();;
  
  public void doUnbind() {
    for(HandlerRegistration reg : _regs_){
    	reg.removeHandler();
    }				
    
  }
  
  protected void doBind() {
    getView().filterRequest(new RequestHandler1<UIGroupTaskCriteria>(){
    			
    			public void execute(UIGroupTaskCriteria c){
    				view_filterRequestExecution(c);
    			}
    			
    		});
    
  }
}
