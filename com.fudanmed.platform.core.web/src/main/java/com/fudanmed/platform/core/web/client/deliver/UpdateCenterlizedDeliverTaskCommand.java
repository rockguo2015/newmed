package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateCenterlizedDeliverTask4PatientPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateCenterlizedDeliverTaskCommand extends BaseContextAwareSingleObjectCommand<DLCenterlizedDeliverTaskProxy> implements IContextConsumer<DLCenterlizedDeliverTaskProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateCenterlizedDeliverTaskCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final DLCenterlizedDeliverTaskProxy value) {
    CreateOrUpdateCenterlizedDeliverTask4PatientPresenter _get = this.createOrUpdateCenterlizedDeliverTaskPresenter.get();
    final Procedure1<CreateOrUpdateCenterlizedDeliverTask4PatientPresenter> _function = new Procedure1<CreateOrUpdateCenterlizedDeliverTask4PatientPresenter>() {
        public void apply(final CreateOrUpdateCenterlizedDeliverTask4PatientPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateCenterlizedDeliverTask4PatientPresenter>() {
        public void done(CreateOrUpdateCenterlizedDeliverTask4PatientPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateCenterlizedDeliverTask4PatientPresenter> createOrUpdateCenterlizedDeliverTaskPresenter;
}
