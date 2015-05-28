package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCheckOrganizationPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateCheckOrganizationCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateCheckOrganizationCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    CreateOrUpdateCheckOrganizationPresenter _get = this.createOrUpdateCheckOrganizationPresenter.get();
    final Procedure1<CreateOrUpdateCheckOrganizationPresenter> _function = new Procedure1<CreateOrUpdateCheckOrganizationPresenter>() {
        public void apply(final CreateOrUpdateCheckOrganizationPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(new IPresenterInitiazerNotifier<CreateOrUpdateCheckOrganizationPresenter>() {
        public void done(CreateOrUpdateCheckOrganizationPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateCheckOrganizationPresenter> createOrUpdateCheckOrganizationPresenter;
}
