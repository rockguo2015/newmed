package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialTypePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateDeliverMaterialTypeCommand extends BaseContextAwareSingleObjectCommand<DLDeliverMaterialCategoryProxy> implements IContextConsumer<DLDeliverMaterialCategoryProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateDeliverMaterialTypeCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final DLDeliverMaterialCategoryProxy value) {
    CreateOrUpdateDeliverMaterialTypePresenter _get = this.createOrUpdateDeliverMaterialTypePresenter.get();
    final Procedure1<CreateOrUpdateDeliverMaterialTypePresenter> _function = new Procedure1<CreateOrUpdateDeliverMaterialTypePresenter>() {
        public void apply(final CreateOrUpdateDeliverMaterialTypePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateDeliverMaterialTypePresenter>() {
        public void done(CreateOrUpdateDeliverMaterialTypePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateDeliverMaterialTypePresenter> createOrUpdateDeliverMaterialTypePresenter;
}
