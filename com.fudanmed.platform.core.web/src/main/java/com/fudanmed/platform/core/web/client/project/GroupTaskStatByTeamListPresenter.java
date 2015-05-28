package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamListPresenterServiceAsync;
import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamListPresenterView;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.async.IPostInitializeAction;
import com.uniquesoft.gwt.shared.datatype.UIDateRange;
import edu.fudan.langlab.uidl.domain.app.client.workbench.WorkbenchAbstractPresenter;
import java.util.Collection;
import java.util.Date;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class GroupTaskStatByTeamListPresenter extends WorkbenchAbstractPresenter<GroupTaskStatByTeamListPresenterView> {
  @Inject
  protected GroupTaskStatByTeamListPresenterServiceAsync _service;
  
  @Inject
  public GroupTaskStatByTeamListPresenter(final GroupTaskStatByTeamListPresenterView display, final EventBus eventBus) {
    super(display,eventBus);
  }
  
  public void setup(final IPresenterInitiazerNotifier<GroupTaskStatByTeamListPresenter> _notifier) {
    
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {_notifier.done(GroupTaskStatByTeamListPresenter.this);
        }
      };
    this.activate(new IPostInitializeAction() {
        public void initializeFinished(Void v) {
          _function.apply(v);
        }
    });
  }
  
  public void setMonth(final String month) {
    
    UIGroupTaskCriteria _uIGroupTaskCriteria = new UIGroupTaskCriteria();
    final Procedure1<UIGroupTaskCriteria> _function = new Procedure1<UIGroupTaskCriteria>() {
        public void apply(final UIGroupTaskCriteria it) {
          it.setMonth(month);
        }
      };
    UIGroupTaskCriteria _doubleArrow = ObjectExtensions.<UIGroupTaskCriteria>operator_doubleArrow(_uIGroupTaskCriteria, _function);
    final Procedure1<Collection<UIGroupTaskStatByTeamCriteriaData>> _function_1 = new Procedure1<Collection<UIGroupTaskStatByTeamCriteriaData>>() {
        public void apply(final Collection<UIGroupTaskStatByTeamCriteriaData> it) {
          GroupTaskStatByTeamListPresenterView _view = GroupTaskStatByTeamListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIGroupTaskStatByTeamCriteriaData>> _onSuccess = this.<Collection<UIGroupTaskStatByTeamCriteriaData>>onSuccess(_function_1);
    _service.loadResult(_doubleArrow, _onSuccess);
  }
  
  public void setDateRange(final UIDateRange dateRange) {
    
    UIGroupTaskCriteria _uIGroupTaskCriteria = new UIGroupTaskCriteria();
    final Procedure1<UIGroupTaskCriteria> _function = new Procedure1<UIGroupTaskCriteria>() {
        public void apply(final UIGroupTaskCriteria it) {
          Date _from = dateRange.getFrom();
          it.setDateFrom(_from);
          Date _to = dateRange.getTo();
          it.setDateTo(_to);
        }
      };
    UIGroupTaskCriteria _doubleArrow = ObjectExtensions.<UIGroupTaskCriteria>operator_doubleArrow(_uIGroupTaskCriteria, _function);
    final Procedure1<Collection<UIGroupTaskStatByTeamCriteriaData>> _function_1 = new Procedure1<Collection<UIGroupTaskStatByTeamCriteriaData>>() {
        public void apply(final Collection<UIGroupTaskStatByTeamCriteriaData> it) {
          GroupTaskStatByTeamListPresenterView _view = GroupTaskStatByTeamListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIGroupTaskStatByTeamCriteriaData>> _onSuccess = this.<Collection<UIGroupTaskStatByTeamCriteriaData>>onSuccess(_function_1);
    _service.loadResult(_doubleArrow, _onSuccess);
  }
  
  public void setReportSource(final UIDateRange dateRange, final RCFaultReportSourceProxy reportSource) {
    
    UIGroupTaskCriteria _uIGroupTaskCriteria = new UIGroupTaskCriteria();
    final Procedure1<UIGroupTaskCriteria> _function = new Procedure1<UIGroupTaskCriteria>() {
        public void apply(final UIGroupTaskCriteria it) {
          Date _from = dateRange.getFrom();
          it.setDateFrom(_from);
          Date _to = dateRange.getTo();
          it.setDateTo(_to);
          it.setFaultReportSource(reportSource);
        }
      };
    UIGroupTaskCriteria _doubleArrow = ObjectExtensions.<UIGroupTaskCriteria>operator_doubleArrow(_uIGroupTaskCriteria, _function);
    final Procedure1<Collection<UIGroupTaskStatByTeamCriteriaData>> _function_1 = new Procedure1<Collection<UIGroupTaskStatByTeamCriteriaData>>() {
        public void apply(final Collection<UIGroupTaskStatByTeamCriteriaData> it) {
          GroupTaskStatByTeamListPresenterView _view = GroupTaskStatByTeamListPresenter.this.getView();
          _view.showResult(it);
        }
      };
    AsyncCallback<Collection<UIGroupTaskStatByTeamCriteriaData>> _onSuccess = this.<Collection<UIGroupTaskStatByTeamCriteriaData>>onSuccess(_function_1);
    _service.loadResult(_doubleArrow, _onSuccess);
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
