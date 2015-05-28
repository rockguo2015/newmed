package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalPatientPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateInHospitalPatientCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateInHospitalPatientCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    CreateOrUpdateInHospitalPatientPresenter _get = this.createOrUpdateInHospitalPatientPresenter.get();
    final Procedure1<DLInHospitalPatientProxy> _function = new Procedure1<DLInHospitalPatientProxy>() {
        public void apply(final DLInHospitalPatientProxy it) {
        }
      };
    final Procedure1<CreateOrUpdateInHospitalPatientPresenter> _function_1 = new Procedure1<CreateOrUpdateInHospitalPatientPresenter>() {
        public void apply(final CreateOrUpdateInHospitalPatientPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(_function, new IPresenterInitiazerNotifier<CreateOrUpdateInHospitalPatientPresenter>() {
        public void done(CreateOrUpdateInHospitalPatientPresenter presenter) {
          _function_1.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateInHospitalPatientPresenter> createOrUpdateInHospitalPatientPresenter;
}
