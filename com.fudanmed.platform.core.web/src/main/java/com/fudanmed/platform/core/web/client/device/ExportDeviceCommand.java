package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.ExportDeviceCommandServiceAsync;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.csv.client.CSVClientExtensions;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class ExportDeviceCommand extends BaseContextAwareSingleObjectCommand<UIDeviceCriteria> implements IContextConsumer<UIDeviceCriteria> {
  @Inject
  protected ExportDeviceCommandServiceAsync _service;
  
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "设备导出";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.ExportDeviceCommand";
  }
  
  public void execute(final UIDeviceCriteria value) {
    final Procedure1<String> _function = new Procedure1<String>() {
        public void apply(final String it) {
          CSVClientExtensions.doDownload(it);
        }
      };
    AsyncCallback<String> _onSuccess = this.<String>onSuccess(_function);
    _service.prepareExport(value, _onSuccess);
  }
}
