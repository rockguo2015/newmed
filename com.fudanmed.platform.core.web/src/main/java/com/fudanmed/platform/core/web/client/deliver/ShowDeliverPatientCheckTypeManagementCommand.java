package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowDeliverPatientCheckTypeManagementCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "检查项目维护";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowDeliverPatientCheckTypeManagementCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    DeliverPatientCheckTypeManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<DeliverPatientCheckTypeManagementPresenter> _function = new Procedure1<DeliverPatientCheckTypeManagementPresenter>() {
        public void apply(final DeliverPatientCheckTypeManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<DeliverPatientCheckTypeManagementPresenter>() {
        public void done(DeliverPatientCheckTypeManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<DeliverPatientCheckTypeManagementPresenter> managementPresenter;
}
