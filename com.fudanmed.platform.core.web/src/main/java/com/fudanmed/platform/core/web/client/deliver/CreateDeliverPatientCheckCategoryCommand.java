package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckCategoryPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class CreateDeliverPatientCheckCategoryCommand extends BaseContextAwareSingleObjectCommand<DLDeliverPatientCheckCategoryProxy> implements IContextConsumer<DLDeliverPatientCheckCategoryProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "新建";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateDeliverPatientCheckCategoryCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final DLDeliverPatientCheckCategoryProxy value) {
    String _plus = ("value==>" + value);
    InputOutput.<String>println(_plus);
    CreateOrUpdateDeliverPatientCheckCategoryPresenter _get = this.createOrUpdateDeliverPatientCheckCategoryPresenter.get();
    final Procedure1<CreateOrUpdateDeliverPatientCheckCategoryPresenter> _function = new Procedure1<CreateOrUpdateDeliverPatientCheckCategoryPresenter>() {
        public void apply(final CreateOrUpdateDeliverPatientCheckCategoryPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Create(value, new IPresenterInitiazerNotifier<CreateOrUpdateDeliverPatientCheckCategoryPresenter>() {
        public void done(CreateOrUpdateDeliverPatientCheckCategoryPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateDeliverPatientCheckCategoryPresenter> createOrUpdateDeliverPatientCheckCategoryPresenter;
}
