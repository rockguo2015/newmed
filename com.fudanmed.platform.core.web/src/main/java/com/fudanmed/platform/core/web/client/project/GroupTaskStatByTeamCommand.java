package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.app.client.workbench.FramedPresenter;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class GroupTaskStatByTeamCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "班组接修统计";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.GroupTaskStatByTeamCommand";
  }
  
  public void execute() {
    GroupTaskStatByTeamPresenter _get = this.groupTaskStatByTeamPresenter.get();
    final Procedure1<GroupTaskStatByTeamPresenter> _function = new Procedure1<GroupTaskStatByTeamPresenter>() {
        public void apply(final GroupTaskStatByTeamPresenter it) {
          FramedPresenter _get = GroupTaskStatByTeamCommand.this.framedPresenter.get();
          final Procedure1<FramedPresenter> _function = new Procedure1<FramedPresenter>() {
              public void apply(final FramedPresenter it) {
                eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
                
              }
            };
          _get.setup("\u73ED\u7EC4\u63A5\u4FEE\u7EDF\u8BA1", it, new IPresenterInitiazerNotifier<FramedPresenter>() {
              public void done(FramedPresenter presenter) {
                _function.apply(presenter);
              }
          });
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<GroupTaskStatByTeamPresenter>() {
        public void done(GroupTaskStatByTeamPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<GroupTaskStatByTeamPresenter> groupTaskStatByTeamPresenter;
  
  @Inject
  private Provider<FramedPresenter> framedPresenter;
}
