package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.UploadDevicePresenter;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.uniquesoft.gwt.client.common.IPresenterInitiazerNotifier;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class UploadDeviceCommand extends BaseSimpleCommand {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "设备导入";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UploadDeviceCommand";
  }
  
  public void execute() {
    UploadDevicePresenter _get = this.uploadDevicePresenter.get();
    final Procedure1<UploadDevicePresenter> _function = new Procedure1<UploadDevicePresenter>() {
        public void apply(final UploadDevicePresenter it) {
          it.popup(it);
        }
      };
    _get.setup(new IPresenterInitiazerNotifier<UploadDevicePresenter>() {
        public void done(UploadDevicePresenter presenter) {
          _function.apply(presenter);
        }
    });
  }
  
  @Inject
  private Provider<UploadDevicePresenter> uploadDevicePresenter;
}
