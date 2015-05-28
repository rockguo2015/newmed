package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DLTaskManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowDLTaskManagementCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "运送任务清单";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowDLTaskManagementCommand";
  }
  
  public void execute() {
    DLTaskManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<DLTaskManagementPresenter> _function = new Procedure1<DLTaskManagementPresenter>() {
        public void apply(final DLTaskManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<DLTaskManagementPresenter>() {
        public void done(DLTaskManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<DLTaskManagementPresenter> managementPresenter;
}
