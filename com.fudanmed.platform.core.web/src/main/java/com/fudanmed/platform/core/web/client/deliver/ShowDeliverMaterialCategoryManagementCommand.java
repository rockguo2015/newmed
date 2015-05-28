package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowDeliverMaterialCategoryManagementCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "运送材料维护";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowDeliverMaterialCategoryManagementCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    DeliverMaterialCategoryManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<DeliverMaterialCategoryManagementPresenter> _function = new Procedure1<DeliverMaterialCategoryManagementPresenter>() {
        public void apply(final DeliverMaterialCategoryManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<DeliverMaterialCategoryManagementPresenter>() {
        public void done(DeliverMaterialCategoryManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<DeliverMaterialCategoryManagementPresenter> managementPresenter;
}
