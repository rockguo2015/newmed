package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalLocationPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateInHospitalLocationCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateInHospitalLocationCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    CreateOrUpdateInHospitalLocationPresenter _get = this.createOrUpdateInHospitalLocationPresenter.get();
    final Procedure1<CreateOrUpdateInHospitalLocationPresenter> _function = new Procedure1<CreateOrUpdateInHospitalLocationPresenter>() {
        public void apply(final CreateOrUpdateInHospitalLocationPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(new IPresenterInitiazerNotifier<CreateOrUpdateInHospitalLocationPresenter>() {
        public void done(CreateOrUpdateInHospitalLocationPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateInHospitalLocationPresenter> createOrUpdateInHospitalLocationPresenter;
}
