package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowPhasedElectricMeasureDeviceManagementCommand extends BaseContextAwareSingleObjectCommand<RCPhasedElectricMeasureDeviceTypeProxy> implements IContextConsumer<RCPhasedElectricMeasureDeviceTypeProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowPhasedElectricMeasureDeviceManagementCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCPhasedElectricMeasureDeviceTypeProxy value) {
    PhasedElectricMeasureDeviceManagementPresenter _get = this.managementPresenter.get();
    final Procedure1<PhasedElectricMeasureDeviceManagementPresenter> _function = new Procedure1<PhasedElectricMeasureDeviceManagementPresenter>() {
        public void apply(final PhasedElectricMeasureDeviceManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(value, new IPresenterInitiazerNotifier<PhasedElectricMeasureDeviceManagementPresenter>() {
        public void done(PhasedElectricMeasureDeviceManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<PhasedElectricMeasureDeviceManagementPresenter> managementPresenter;
}
