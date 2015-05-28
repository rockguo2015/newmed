package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowCheckOrganizationManagementCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "检查科室维护";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowCheckOrganizationManagementCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    CheckOrganizationManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<CheckOrganizationManagementPresenter> _function = new Procedure1<CheckOrganizationManagementPresenter>() {
        public void apply(final CheckOrganizationManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<CheckOrganizationManagementPresenter>() {
        public void done(CheckOrganizationManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CheckOrganizationManagementPresenter> managementPresenter;
}
