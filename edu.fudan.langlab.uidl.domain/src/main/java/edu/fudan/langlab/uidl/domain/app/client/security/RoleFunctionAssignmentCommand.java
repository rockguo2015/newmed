package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.app.client.security.RoleFunctionAssignmentPresenter;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class RoleFunctionAssignmentCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "系统功能权限设置";
  }
  
  public String getActionId() {
    return "edu.fudan.langlab.uidl.domain.app.roleFunctionAssignmentPresenter";
  }
  
  public void execute() {
    final Procedure1<RoleFunctionAssignmentPresenter> _function = new Procedure1<RoleFunctionAssignmentPresenter>() {
        public void apply(final RoleFunctionAssignmentPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    this.roleFunctionAssignmentPresenter.setup(_function);
  }
  
  @Inject
  private RoleFunctionAssignmentPresenter roleFunctionAssignmentPresenter;
}
