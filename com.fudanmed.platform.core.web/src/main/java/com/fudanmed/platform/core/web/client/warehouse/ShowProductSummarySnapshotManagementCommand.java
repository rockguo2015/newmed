package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowProductSummarySnapshotManagementCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "库存变动查询";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowProductSummarySnapshotManagementCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    ProductSummarySnapshotManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<ProductSummarySnapshotManagementPresenter> _function = new Procedure1<ProductSummarySnapshotManagementPresenter>() {
        public void apply(final ProductSummarySnapshotManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<ProductSummarySnapshotManagementPresenter>() {
        public void done(ProductSummarySnapshotManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<ProductSummarySnapshotManagementPresenter> managementPresenter;
}
