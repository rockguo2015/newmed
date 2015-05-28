package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairTaskStatByReportSourcePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.app.client.workbench.FramedPresenter;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairTaskStatByReportSourceCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "报修来源统计";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.RepairTaskStatByReportSourceCommand";
  }
  
  public void execute() {
    RepairTaskStatByReportSourcePresenter _get = this.repairTaskStatByReportSourcePresenter.get();
    final Procedure1<RepairTaskStatByReportSourcePresenter> _function = new Procedure1<RepairTaskStatByReportSourcePresenter>() {
        public void apply(final RepairTaskStatByReportSourcePresenter it) {
          FramedPresenter _get = RepairTaskStatByReportSourceCommand.this.framedPresenter.get();
          final Procedure1<FramedPresenter> _function = new Procedure1<FramedPresenter>() {
              public void apply(final FramedPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
                
              }
            };
          _get.setup("\u62A5\u4FEE\u6765\u6E90\u7EDF\u8BA1", it, new IPresenterInitiazerNotifier<FramedPresenter>() {
              public void done(FramedPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<RepairTaskStatByReportSourcePresenter>() {
        public void done(RepairTaskStatByReportSourcePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<RepairTaskStatByReportSourcePresenter> repairTaskStatByReportSourcePresenter;
  
  @Inject
  private Provider<FramedPresenter> framedPresenter;
}
