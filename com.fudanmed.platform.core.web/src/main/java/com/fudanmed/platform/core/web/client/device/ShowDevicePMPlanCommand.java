package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DevicePMPlanSelectorPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowDevicePMPlanCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "PM计划查询";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowDevicePMPlanCommand";
  }
  
  public void execute() {
    DevicePMPlanSelectorPresenter _get = this.devicePMPlanSelectorPresenter.get();
    final Procedure1<DevicePMPlanSelectorPresenter> _function = new Procedure1<DevicePMPlanSelectorPresenter>() {
        public void apply(final DevicePMPlanSelectorPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<DevicePMPlanSelectorPresenter>() {
        public void done(DevicePMPlanSelectorPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<DevicePMPlanSelectorPresenter> devicePMPlanSelectorPresenter;
}
