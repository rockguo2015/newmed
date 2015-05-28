package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckTypePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateDeliverPatientCheckTypeCommand extends BaseContextAwareSingleObjectCommand<DLDeliverPatientCheckTypeProxy> implements IContextConsumer<DLDeliverPatientCheckTypeProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateDeliverPatientCheckTypeCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final DLDeliverPatientCheckTypeProxy value) {
    CreateOrUpdateDeliverPatientCheckTypePresenter _get = this.createOrUpdateDeliverPatientCheckTypePresenter.get();
    final Procedure1<CreateOrUpdateDeliverPatientCheckTypePresenter> _function = new Procedure1<CreateOrUpdateDeliverPatientCheckTypePresenter>() {
        public void apply(final CreateOrUpdateDeliverPatientCheckTypePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateDeliverPatientCheckTypePresenter>() {
        public void done(CreateOrUpdateDeliverPatientCheckTypePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateDeliverPatientCheckTypePresenter> createOrUpdateDeliverPatientCheckTypePresenter;
}
