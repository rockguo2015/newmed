package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.web.client.measure.DeleteElectricMeasureDeviceCommandServiceAsync;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class DeleteElectricMeasureDeviceCommand extends BaseContextAwareSingleObjectCommand<RCElectricMeasureDeviceProxy> implements IContextConsumer<RCElectricMeasureDeviceProxy> {
  @Inject
  protected DeleteElectricMeasureDeviceCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "删除";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.DeleteElectricMeasureDeviceCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCElectricMeasureDeviceProxy value) {
    String _name = value.getName();
    String _plus = ("\u786E\u8BA4\u5220\u9664:" + _name);
    final Procedure1<Void> _function = new Procedure1<Void>() {
        public void apply(final Void it) {
          final Procedure1<Void> _function = new Procedure1<Void>() {
              public void apply(final Void it) {eventBus.fireEvent(new com.fudanmed.platform.core.web.client.measure.ElectricMeasureDevicesChangedEvent());
                
              }
            };
          AsyncCallback<Void> _onSuccess = DeleteElectricMeasureDeviceCommand.this.<Void>onSuccess(_function);
          _service.delete(value, _onSuccess);
        }
      };
    ConfirmMessageBox _ConfirmMessageBox = this.widgets.ConfirmMessageBox("\u786E\u8BA4\u5220\u9664", _plus, _function);
    _ConfirmMessageBox.show();
  }
}
