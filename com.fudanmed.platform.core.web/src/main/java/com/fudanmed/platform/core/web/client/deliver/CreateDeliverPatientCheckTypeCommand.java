package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckTypePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateDeliverPatientCheckTypeCommand extends BaseContextAwareSingleObjectCommand<DLDeliverPatientCheckCategoryProxy> implements IContextConsumer<DLDeliverPatientCheckCategoryProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateDeliverPatientCheckTypeCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final DLDeliverPatientCheckCategoryProxy value) {
    CreateOrUpdateDeliverPatientCheckTypePresenter _get = this.createOrUpdateDeliverPatientCheckTypePresenter.get();
    final Procedure1<CreateOrUpdateDeliverPatientCheckTypePresenter> _function = new Procedure1<CreateOrUpdateDeliverPatientCheckTypePresenter>() {
        public void apply(final CreateOrUpdateDeliverPatientCheckTypePresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateDeliverPatientCheckTypePresenter>() {
        public void done(CreateOrUpdateDeliverPatientCheckTypePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateDeliverPatientCheckTypePresenter> createOrUpdateDeliverPatientCheckTypePresenter;
}
