package edu.fudan.langlab.uidl.domain.code.client.web;

import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import edu.fudan.langlab.uidl.domain.code.client.web.CodeManagementPresenter;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowCodeManagementCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "基础代码维护";
  }
  
  public String getActionId() {
    return "edu.fudan.langlab.uidl.domain.app.codeManagementPresenter";
  }
  
  public void execute() {
    final Procedure1<CodeManagementPresenter> _function = new Procedure1<CodeManagementPresenter>() {
        public void apply(final CodeManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    this.roleManagementPresenter.setup(new IPresenterInitiazerNotifier<CodeManagementPresenter>() {
        public void done(CodeManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private CodeManagementPresenter roleManagementPresenter;
}
