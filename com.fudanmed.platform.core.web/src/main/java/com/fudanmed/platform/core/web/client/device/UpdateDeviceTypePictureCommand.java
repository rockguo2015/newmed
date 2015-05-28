package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.UpdatePictureCommand;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;

public class UpdateDeviceTypePictureCommand extends BaseContextAwareSingleObjectCommand<DocumentStorageProxy> implements IContextConsumer<DocumentStorageProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "修改设备图片";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.UpdateDeviceTypePictureCommand";
  }
  
  public void execute(final DocumentStorageProxy value) {
    this.delegate.execute(value);
  }
  
  @Inject
  private UpdatePictureCommand delegate;
}
