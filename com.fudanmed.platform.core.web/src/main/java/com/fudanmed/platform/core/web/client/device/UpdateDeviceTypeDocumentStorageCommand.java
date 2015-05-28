package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.UpdateDocumentStorageCommand;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;

public class UpdateDeviceTypeDocumentStorageCommand extends BaseContextAwareSingleObjectCommand<DocumentStorageProxy> implements IContextConsumer<DocumentStorageProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改设备文档";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateDeviceTypeDocumentStorageCommand";
  }
  
  public void execute(final DocumentStorageProxy value) {
    this.deletage.execute(value);
  }
  
  @Inject
  private UpdateDocumentStorageCommand deletage;
}
