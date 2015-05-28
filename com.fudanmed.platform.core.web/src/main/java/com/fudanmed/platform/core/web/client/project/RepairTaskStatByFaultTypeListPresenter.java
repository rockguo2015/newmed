package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByFaultTypeCriteriaData;
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

public class RepairTaskStatByFaultTypeListPresenter extends WorkbenchAbstractPresenter<RepairTaskStatByFaultTypeListPresenterView> {
  @Inject
  protected RepairTaskStatByFaultTypeListPresenterServiceAsync _service;
  
  @Inject
  public RepairTaskStatByFaultTypeListPresenter(final RepairTaskStatByFaultTypeListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<RepairTaskStatByFaultTypeListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(RepairTaskStatByFaultTypeListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setMonth(final String month) {
    
    final Procedure1<Collection<UIRepairTaskStatByFaultTypeCriteriaData>> _function = new Procedure1<Collection<UIRepairTaskStatByFaultTypeCriteriaData>>() {
        public void apply(final Collection<UIRepairTaskStatByFaultTypeCriteriaData> it) {
          RepairTaskStatByFaultTypeListPresenterView _view = RepairTaskStatByFaultTypeListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIRepairTaskStatByFaultTypeCriteriaData>> _onSuccess = this.<Collection<UIRepairTaskStatByFaultTypeCriteriaData>>onSuccess(_function);
    _service.load(month, _onSuccess);
  }
  
  public void setReportSource(final UIDateRange dateRange, final RCFaultReportSourceProxy reportSource) {
    
    final Procedure1<Collection<UIRepairTaskStatByFaultTypeCriteriaData>> _function = new Procedure1<Collection<UIRepairTaskStatByFaultTypeCriteriaData>>() {
        public void apply(final Collection<UIRepairTaskStatByFaultTypeCriteriaData> it) {
          RepairTaskStatByFaultTypeListPresenterView _view = RepairTaskStatByFaultTypeListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIRepairTaskStatByFaultTypeCriteriaData>> _onSuccess = this.<Collection<UIRepairTaskStatByFaultTypeCriteriaData>>onSuccess(_function);
    _service.load(dateRange, reportSource, _onSuccess);
  }
  
  public void setDateRange(final UIDateRange dateRange) {
    
    final Procedure1<Collection<UIRepairTaskStatByFaultTypeCriteriaData>> _function = new Procedure1<Collection<UIRepairTaskStatByFaultTypeCriteriaData>>() {
        public void apply(final Collection<UIRepairTaskStatByFaultTypeCriteriaData> it) {
          RepairTaskStatByFaultTypeListPresenterView _view = RepairTaskStatByFaultTypeListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIRepairTaskStatByFaultTypeCriteriaData>> _onSuccess = this.<Collection<UIRepairTaskStatByFaultTypeCriteriaData>>onSuccess(_function);
    _service.load(dateRange, _onSuccess);
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
