package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowInHospitalLocationManagementCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "病区信息维护";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowInHospitalLocationManagementCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    InHospitalLocationManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<InHospitalLocationManagementPresenter> _function = new Procedure1<InHospitalLocationManagementPresenter>() {
        public void apply(final InHospitalLocationManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<InHospitalLocationManagementPresenter>() {
        public void done(InHospitalLocationManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<InHospitalLocationManagementPresenter> managementPresenter;
}
