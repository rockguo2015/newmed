package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialCategoryPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateDeliverMaterialCategoryCommand extends BaseContextAwareSingleObjectCommand<DLDeliverMaterialCategoryProxy> implements IContextConsumer<DLDeliverMaterialCategoryProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateDeliverMaterialCategoryCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final DLDeliverMaterialCategoryProxy value) {
    CreateOrUpdateDeliverMaterialCategoryPresenter _get = this.createOrUpdateDeliverMaterialCategoryPresenter.get();
    final Procedure1<CreateOrUpdateDeliverMaterialCategoryPresenter> _function = new Procedure1<CreateOrUpdateDeliverMaterialCategoryPresenter>() {
        public void apply(final CreateOrUpdateDeliverMaterialCategoryPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateDeliverMaterialCategoryPresenter>() {
        public void done(CreateOrUpdateDeliverMaterialCategoryPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateDeliverMaterialCategoryPresenter> createOrUpdateDeliverMaterialCategoryPresenter;
}
