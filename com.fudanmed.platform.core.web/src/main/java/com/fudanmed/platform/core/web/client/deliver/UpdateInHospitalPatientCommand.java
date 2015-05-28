package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateInHospitalPatientPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateInHospitalPatientCommand extends BaseContextAwareSingleObjectCommand<DLInHospitalPatientProxy> implements IContextConsumer<DLInHospitalPatientProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateInHospitalPatientCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final DLInHospitalPatientProxy value) {
    CreateOrUpdateInHospitalPatientPresenter _get = this.createOrUpdateInHospitalPatientPresenter.get();
    final Procedure1<CreateOrUpdateInHospitalPatientPresenter> _function = new Procedure1<CreateOrUpdateInHospitalPatientPresenter>() {
        public void apply(final CreateOrUpdateInHospitalPatientPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateInHospitalPatientPresenter>() {
        public void done(CreateOrUpdateInHospitalPatientPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateInHospitalPatientPresenter> createOrUpdateInHospitalPatientPresenter;
}
