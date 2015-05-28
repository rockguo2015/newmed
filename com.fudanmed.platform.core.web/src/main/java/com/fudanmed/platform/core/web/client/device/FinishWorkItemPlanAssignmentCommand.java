package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCWorkItemPlanAssignmentProxy;
import com.fudanmed.platform.core.web.client.device.FinishWorkItemPlanAssignmentPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareMultiObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class FinishWorkItemPlanAssignmentCommand extends BaseContextAwareMultiObjectCommand<RCWorkItemPlanAssignmentProxy> implements IContextConsumer<RCWorkItemPlanAssignmentProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "已维保";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.FinishWorkItemPlanAssignmentCommand";
  }
  
  public void execute(final Iterable<RCWorkItemPlanAssignmentProxy> value) {
    FinishWorkItemPlanAssignmentPresenter _get = this.p.get();
    final Procedure1<FinishWorkItemPlanAssignmentPresenter> _function = new Procedure1<FinishWorkItemPlanAssignmentPresenter>() {
        public void apply(final FinishWorkItemPlanAssignmentPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.PopActivatedPresenterEvent(it));
          
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<FinishWorkItemPlanAssignmentPresenter>() {
        public void done(FinishWorkItemPlanAssignmentPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<FinishWorkItemPlanAssignmentPresenter> p;
}
