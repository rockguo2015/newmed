package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.client.project.ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommand;
import com.fudanmed.platform.core.web.client.project.WorkItemStockRecordItemStat4ProductEntryListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.WorkItemStockRecordItemStat4ProductEntryListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStatCriteria;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class WorkItemStockRecordItemStat4ProductEntryListPresenter extends WorkbenchAbstractPresenter<WorkItemStockRecordItemStat4ProductEntryListPresenterView> {
  @Inject
  protected WorkItemStockRecordItemStat4ProductEntryListPresenterServiceAsync _service;
  
  @Inject
  public WorkItemStockRecordItemStat4ProductEntryListPresenter(final WorkItemStockRecordItemStat4ProductEntryListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  @Inject
  private ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommand exportCommand;
  
  private UIWorkItemStockRecordItemStatCriteria uicriteria;
  
  public void setup(final IPresenterInitiazerNotifier<WorkItemStockRecordItemStat4ProductEntryListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(WorkItemStockRecordItemStat4ProductEntryListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setCriteria(final RCMaintenanceTeamProxy team, final Date dateFrom, final Date dateTo) {
    
    UIWorkItemStockRecordItemStatCriteria _uIWorkItemStockRecordItemStatCriteria = new UIWorkItemStockRecordItemStatCriteria();
    final Procedure1<UIWorkItemStockRecordItemStatCriteria> _function = new Procedure1<UIWorkItemStockRecordItemStatCriteria>() {
        public void apply(final UIWorkItemStockRecordItemStatCriteria it) {
          it.setTeam(team);
          it.setDateFrom(dateFrom);
          it.setDateTo(dateTo);
        }
      };
    UIWorkItemStockRecordItemStatCriteria _doubleArrow = ObjectExtensions.<UIWorkItemStockRecordItemStatCriteria>operator_doubleArrow(_uIWorkItemStockRecordItemStatCriteria, _function);
    this.uicriteria = _doubleArrow;
    this.setCriteria(this.uicriteria);
  }
  
  public void setCriteria(final UIWorkItemStockRecordItemStatCriteria uicriteria) {
    
    this.uicriteria = uicriteria;
    final Procedure1<Collection<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData>> _function = new Procedure1<Collection<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData>>() {
        public void apply(final Collection<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> it) {
          WorkItemStockRecordItemStat4ProductEntryListPresenterView _view = WorkItemStockRecordItemStat4ProductEntryListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData>> _onSuccess = this.<Collection<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData>>onSuccess(_function);
    _service.load(uicriteria, _onSuccess);
  }
  
  public void export() {
    
    this.exportCommand.execute(this.uicriteria);
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
