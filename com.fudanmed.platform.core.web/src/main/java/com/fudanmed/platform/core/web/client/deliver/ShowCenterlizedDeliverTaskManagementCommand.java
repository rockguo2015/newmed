package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CenterlizedDeliverTaskManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowCenterlizedDeliverTaskManagementCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "中央运送管理";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowCenterlizedDeliverTaskManagementCommand";
  }
  
  public void execute() {
    CenterlizedDeliverTaskManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<CenterlizedDeliverTaskManagementPresenter> _function = new Procedure1<CenterlizedDeliverTaskManagementPresenter>() {
        public void apply(final CenterlizedDeliverTaskManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<CenterlizedDeliverTaskManagementPresenter>() {
        public void done(CenterlizedDeliverTaskManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CenterlizedDeliverTaskManagementPresenter> managementPresenter;
}
