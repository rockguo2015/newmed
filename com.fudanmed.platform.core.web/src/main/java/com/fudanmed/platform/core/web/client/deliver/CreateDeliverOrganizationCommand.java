package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverOrganizationPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateDeliverOrganizationCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateDeliverOrganizationCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    CreateOrUpdateDeliverOrganizationPresenter _get = this.createOrUpdateDeliverOrganizationPresenter.get();
    final Procedure1<CreateOrUpdateDeliverOrganizationPresenter> _function = new Procedure1<CreateOrUpdateDeliverOrganizationPresenter>() {
        public void apply(final CreateOrUpdateDeliverOrganizationPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(new IPresenterInitiazerNotifier<CreateOrUpdateDeliverOrganizationPresenter>() {
        public void done(CreateOrUpdateDeliverOrganizationPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateDeliverOrganizationPresenter> createOrUpdateDeliverOrganizationPresenter;
}
