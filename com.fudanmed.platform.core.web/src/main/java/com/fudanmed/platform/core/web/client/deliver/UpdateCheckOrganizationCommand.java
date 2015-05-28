package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCheckOrganizationPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateCheckOrganizationCommand extends BaseContextAwareSingleObjectCommand<DLCheckOrganizationProxy> implements IContextConsumer<DLCheckOrganizationProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateCheckOrganizationCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final DLCheckOrganizationProxy value) {
    CreateOrUpdateCheckOrganizationPresenter _get = this.createOrUpdateCheckOrganizationPresenter.get();
    final Procedure1<CreateOrUpdateCheckOrganizationPresenter> _function = new Procedure1<CreateOrUpdateCheckOrganizationPresenter>() {
        public void apply(final CreateOrUpdateCheckOrganizationPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateCheckOrganizationPresenter>() {
        public void done(CreateOrUpdateCheckOrganizationPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateCheckOrganizationPresenter> createOrUpdateCheckOrganizationPresenter;
}
