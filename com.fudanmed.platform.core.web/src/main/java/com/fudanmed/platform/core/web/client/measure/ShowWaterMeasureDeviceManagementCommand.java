package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowWaterMeasureDeviceManagementCommand extends BaseContextAwareSingleObjectCommand<RCWaterMeasureDeviceTypeProxy> implements IContextConsumer<RCWaterMeasureDeviceTypeProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowWaterMeasureDeviceManagementCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCWaterMeasureDeviceTypeProxy value) {
    WaterMeasureDeviceManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<WaterMeasureDeviceManagementPresenter> _function = new Procedure1<WaterMeasureDeviceManagementPresenter>() {
        public void apply(final WaterMeasureDeviceManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(value, new IPresenterInitiazerNotifier<WaterMeasureDeviceManagementPresenter>() {
        public void done(WaterMeasureDeviceManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<WaterMeasureDeviceManagementPresenter> managementPresenter;
}
