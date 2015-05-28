package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairTaskStatByMonthPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.app.client.workbench.FramedPresenter;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RepairTaskStatByMonthCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "月份报修统计";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.RepairTaskStatByMonthCommand";
  }
  
  public void execute() {
    RepairTaskStatByMonthPresenter _get = this.repairTaskStatByMonthPresenter.get();
    final Procedure1<RepairTaskStatByMonthPresenter> _function = new Procedure1<RepairTaskStatByMonthPresenter>() {
        public void apply(final RepairTaskStatByMonthPresenter it) {
          FramedPresenter _get = RepairTaskStatByMonthCommand.this.framedPresenter.get();
          final Procedure1<FramedPresenter> _function = new Procedure1<FramedPresenter>() {
              public void apply(final FramedPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
                
              }
            };
          _get.setup("\u6708\u4EFD\u62A5\u4FEE\u7EDF\u8BA1", it, new IPresenterInitiazerNotifier<FramedPresenter>() {
              public void done(FramedPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<RepairTaskStatByMonthPresenter>() {
        public void done(RepairTaskStatByMonthPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<RepairTaskStatByMonthPresenter> repairTaskStatByMonthPresenter;
  
  @Inject
  private Provider<FramedPresenter> framedPresenter;
}
