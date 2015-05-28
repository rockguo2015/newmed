package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByOrganizationTypeCriteriaData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairTaskStatByOrganizationTypeListPresenter extends WorkbenchAbstractPresenter<RepairTaskStatByOrganizationTypeListPresenterView> {
  @Inject
  protected RepairTaskStatByOrganizationTypeListPresenterServiceAsync _service;
  
  @Inject
  public RepairTaskStatByOrganizationTypeListPresenter(final RepairTaskStatByOrganizationTypeListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<RepairTaskStatByOrganizationTypeListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(RepairTaskStatByOrganizationTypeListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setMonth(final String month) {
    
    final Procedure1<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>> _function = new Procedure1<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>>() {
        public void apply(final Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> it) {
          RepairTaskStatByOrganizationTypeListPresenterView _view = RepairTaskStatByOrganizationTypeListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>> _onSuccess = this.<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>>onSuccess(_function);
    _service.load(month, _onSuccess);
  }
  
  public void setDateRange(final UIDateRange dateRange) {
    
    final Procedure1<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>> _function = new Procedure1<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>>() {
        public void apply(final Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> it) {
          RepairTaskStatByOrganizationTypeListPresenterView _view = RepairTaskStatByOrganizationTypeListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>> _onSuccess = this.<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>>onSuccess(_function);
    _service.load(dateRange, _onSuccess);
  }
  
  public void setReportSource(final UIDateRange dateRange, final RCFaultReportSourceProxy reportSource) {
    
    final Procedure1<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>> _function = new Procedure1<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>>() {
        public void apply(final Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> it) {
          RepairTaskStatByOrganizationTypeListPresenterView _view = RepairTaskStatByOrganizationTypeListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>> _onSuccess = this.<Collection<UIRepairTaskStatByOrganizationTypeCriteriaData>>onSuccess(_function);
    _service.load(dateRange, reportSource, _onSuccess);
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
