package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.web.client.device.CreateOrUpdateDevicePMPlanPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UpdateDevicePMPlanCommand extends BaseContextAwareSingleObjectCommand<RCDevicePMPlanProxy> implements IContextConsumer<RCDevicePMPlanProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改PM计划";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateDevicePMPlanCommand";
  }
  
  public void execute(final RCDevicePMPlanProxy value) {
    CreateOrUpdateDevicePMPlanPresenter _get = this.createOrUpdateDevicePMPlanPresenter.get();
    final Procedure1<CreateOrUpdateDevicePMPlanPresenter> _function = new Procedure1<CreateOrUpdateDevicePMPlanPresenter>() {
        public void apply(final CreateOrUpdateDevicePMPlanPresenter it) {
          it.popup(it);
        }
      };
    _get.setup4Update(value, new IPresenterInitiazerNotifier<CreateOrUpdateDevicePMPlanPresenter>() {
        public void done(CreateOrUpdateDevicePMPlanPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<CreateOrUpdateDevicePMPlanPresenter> createOrUpdateDevicePMPlanPresenter;
}
