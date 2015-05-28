package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreatePictureCommand;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.domain.document.proxy.IDocumentContainerProxy;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;

public class CreateDeviceTypePictureCommand extends BaseContextAwareSingleObjectCommand<IDocumentContainerProxy> implements IContextConsumer<IDocumentContainerProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "上传设备图片";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.CreateDeviceTypePictureCommand";
  }
  
  public void execute(final IDocumentContainerProxy value) {
    this.delegate.execute(value);
  }
  
  @Inject
  private CreatePictureCommand delegate;
}