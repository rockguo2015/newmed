package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowElectricMeasureDeviceManagementCommand extends BaseContextAwareSingleObjectCommand<RCElectricMeasureDeviceTypeProxy> implements IContextConsumer<RCElectricMeasureDeviceTypeProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowElectricMeasureDeviceManagementCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCElectricMeasureDeviceTypeProxy value) {
    ElectricMeasureDeviceManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<ElectricMeasureDeviceManagementPresenter> _function = new Procedure1<ElectricMeasureDeviceManagementPresenter>() {
        public void apply(final ElectricMeasureDeviceManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(value, new IPresenterInitiazerNotifier<ElectricMeasureDeviceManagementPresenter>() {
        public void done(ElectricMeasureDeviceManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<ElectricMeasureDeviceManagementPresenter> managementPresenter;
}
