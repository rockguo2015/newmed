package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowDeliverOrganizationManagementCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "运送部门维护";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowDeliverOrganizationManagementCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    DeliverOrganizationManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<DeliverOrganizationManagementPresenter> _function = new Procedure1<DeliverOrganizationManagementPresenter>() {
        public void apply(final DeliverOrganizationManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<DeliverOrganizationManagementPresenter>() {
        public void done(DeliverOrganizationManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<DeliverOrganizationManagementPresenter> managementPresenter;
}
