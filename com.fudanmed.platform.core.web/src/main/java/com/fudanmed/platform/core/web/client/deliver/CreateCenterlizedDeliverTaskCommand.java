package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateCenterlizedDeliverTaskCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "运送病人";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateCenterlizedDeliverTaskCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    CreateOrUpdateCenterlizedDeliverTask4PatientPresenter _get = this.createOrUpdateCenterlizedDeliverTaskPresenter.get();
    final Procedure1<CreateOrUpdateCenterlizedDeliverTask4PatientPresenter> _function = new Procedure1<CreateOrUpdateCenterlizedDeliverTask4PatientPresenter>() {
        public void apply(final CreateOrUpdateCenterlizedDeliverTask4PatientPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(new IPresenterInitiazerNotifier<CreateOrUpdateCenterlizedDeliverTask4PatientPresenter>() {
        public void done(CreateOrUpdateCenterlizedDeliverTask4PatientPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateCenterlizedDeliverTask4PatientPresenter> createOrUpdateCenterlizedDeliverTaskPresenter;
}
