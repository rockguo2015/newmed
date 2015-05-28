package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.MeasureDeviceManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowMeasureDeviceManagementPresenterCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "抄表设备维护";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowMeasureDeviceManagementPresenterCommand";
  }
  
  public void execute() {
    MeasureDeviceManagementPresenter _get = this.measureDeviceManagementPresenter.get();
    final Procedure1<MeasureDeviceManagementPresenter> _function = new Procedure1<MeasureDeviceManagementPresenter>() {
        public void apply(final MeasureDeviceManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<MeasureDeviceManagementPresenter>() {
        public void done(MeasureDeviceManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<MeasureDeviceManagementPresenter> measureDeviceManagementPresenter;
}
