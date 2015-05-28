package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.web.client.measure.MeasureDeviceValueManagementPresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ShowMeasureDeviceValueManagementPresenterCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "抄表管理";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ShowMeasureDeviceValueManagementPresenterCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute() {
    MeasureDeviceValueManagementPresenter _get = this.measureDeviceValueManagementPresenter.get();
    final Procedure1<MeasureDeviceValueManagementPresenter> _function = new Procedure1<MeasureDeviceValueManagementPresenter>() {
        public void apply(final MeasureDeviceValueManagementPresenter it) {
          eventBus.fireEvent(new edu.fudan.langlab.uidl.domain.app.client.workbench.ShowActivePresenterEvent(it));
          
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<MeasureDeviceValueManagementPresenter>() {
        public void done(MeasureDeviceValueManagementPresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<MeasureDeviceValueManagementPresenter> measureDeviceValueManagementPresenter;
}
