package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverOrganizationPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateDeliverOrganizationCommand extends BaseContextAwareSingleObjectCommand<DLDeliverOrganizationProxy> implements IContextConsumer<DLDeliverOrganizationProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateDeliverOrganizationCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final DLDeliverOrganizationProxy value) {
    CreateOrUpdateDeliverOrganizationPresenter _get = this.createOrUpdateDeliverOrganizationPresenter.get();
    final Procedure1<CreateOrUpdateDeliverOrganizationPresenter> _function = new Procedure1<CreateOrUpdateDeliverOrganizationPresenter>() {
        public void apply(final CreateOrUpdateDeliverOrganizationPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateDeliverOrganizationPresenter>() {
        public void done(CreateOrUpdateDeliverOrganizationPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateDeliverOrganizationPresenter> createOrUpdateDeliverOrganizationPresenter;
}
