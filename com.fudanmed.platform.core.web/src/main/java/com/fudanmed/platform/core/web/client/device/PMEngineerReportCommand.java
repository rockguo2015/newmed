package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemWorkerAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.PMEngineerReportPresenter;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignment;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignmentStatus;
import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PMEngineerReportCommand extends BaseContextAwareSingleObjectCommand<UIPMWorkItemWorkerAssignment> implements IContextConsumer<UIPMWorkItemWorkerAssignment> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "执行记录";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.PMEngineerReportCommand";
  }
  
  public void execute(final UIPMWorkItemWorkerAssignment value) {
    PMEngineerReportPresenter _get = this.engineerReportPresenter.get();
    RCPMWorkItemWorkerAssignmentProxy _proxy = value.toProxy();
    final Procedure1<PMEngineerReportPresenter> _function = new Procedure1<PMEngineerReportPresenter>() {
        public void apply(final PMEngineerReportPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup(_proxy, new IPresenterInitiazerNotifier<PMEngineerReportPresenter>() {
        public void done(PMEngineerReportPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  public boolean checkEnable(final UIPMWorkItemWorkerAssignment value) {
    boolean _and = false;
    boolean _or = false;
    UIPMWorkItemWorkerAssignmentStatus _status = value.getStatus();
    boolean _equals = Objects.equal(_status, UIPMWorkItemWorkerAssignmentStatus.pending);
    if (_equals) {
      _or = true;
    } else {
      UIPMWorkItemWorkerAssignmentStatus _status_1 = value.getStatus();
      boolean _equals_1 = Objects.equal(_status_1, UIPMWorkItemWorkerAssignmentStatus.planed);
      _or = (_equals || _equals_1);
    }
    if (!_or) {
      _and = false;
    } else {
      Boolean _allTaskFinished = value.getAllTaskFinished();
      boolean _not = (!_allTaskFinished);
      _and = (_or && _not);
    }
    return _and;
  }
  
  @Inject
  private Provider<PMEngineerReportPresenter> engineerReportPresenter;
}
