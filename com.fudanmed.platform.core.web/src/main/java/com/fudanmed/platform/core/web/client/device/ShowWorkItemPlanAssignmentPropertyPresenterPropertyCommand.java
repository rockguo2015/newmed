package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.WorkItemPlanAssignmentPropertyPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowWorkItemPlanAssignmentPropertyPresenterPropertyCommand extends BaseContextAwareSingleObjectCommand<RCWorkItemPlanAssignmentProxy> implements IContextConsumer<RCWorkItemPlanAssignmentProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "查看设备详情";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowWorkItemPlanAssignmentPropertyPresenterPropertyCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCWorkItemPlanAssignmentProxy value) {
    WorkItemPlanAssignmentPropertyPresenter _get = this.workItemPlanAssignmentPropertyPresenter.get();
    final Procedure1<WorkItemPlanAssignmentPropertyPresenter> _function = new Procedure1<WorkItemPlanAssignmentPropertyPresenter>() {
        public void apply(final WorkItemPlanAssignmentPropertyPresenter it) {
          it.setValue(value);
          it.popup(it);
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<WorkItemPlanAssignmentPropertyPresenter>() {
        public void done(WorkItemPlanAssignmentPropertyPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<WorkItemPlanAssignmentPropertyPresenter> workItemPlanAssignmentPropertyPresenter;
}
