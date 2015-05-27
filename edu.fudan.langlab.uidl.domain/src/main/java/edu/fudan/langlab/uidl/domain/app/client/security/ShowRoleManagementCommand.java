package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleManagementPresenter;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowRoleManagementCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "系统角色管理";
  }
  
  public String getActionId() {
    return "edu.fudan.langlab.uidl.domain.app.roleManagementPresenter";
  }
  
  public void execute() {
    final Procedure1<RoleManagementPresenter> _function = new Procedure1<RoleManagementPresenter>() {
        public void apply(final RoleManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    this.roleManagementPresenter.setup(_function);
  }
  
  @Inject
  private RoleManagementPresenter roleManagementPresenter;
}
