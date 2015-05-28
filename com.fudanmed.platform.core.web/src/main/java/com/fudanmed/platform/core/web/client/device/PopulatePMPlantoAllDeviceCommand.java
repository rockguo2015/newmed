package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PopulatePMPlantoAllDeviceCommandServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.info.Info;
import com.uniquesoft.gwt.client.common.command.BaseSimpleCommand;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class PopulatePMPlantoAllDeviceCommand extends BaseSimpleCommand {
  @Inject
  protected PopulatePMPlantoAllDeviceCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "PM初始化";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.PopulatePMPlantoAllDeviceCommand";
  }
  
  public void execute() {
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {
                Info.display("success", "\u751F\u6210\u6240\u6709PM\u8BA1\u5212");
              }
            };
          AsyncCallback<Void> _onSuccess = PopulatePMPlantoAllDeviceCommand.this.<Void>onSuccess(_function);
          _service.populateAll(_onSuccess);
        }
      };
    ConfirmMessageBox _ConfirmMessageBox = this.widgets.ConfirmMessageBox("\u786E\u8BA4", "\u751F\u6210\u6240\u6709PM\u8BA1\u5212", _function);
    _ConfirmMessageBox.show();
  }
}
