package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DeletePictureCommand;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.domain.document.proxy.DocumentStorageProxy;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;

public class DeleteDevicePictureCommand extends BaseContextAwareSingleObjectCommand<DocumentStorageProxy> implements IContextConsumer<DocumentStorageProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "删除设备图片";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.DeleteDevicePictureCommand";
  }
  
  public void execute(final DocumentStorageProxy value) {
    this.delegate.execute(value);
  }
  
  @Inject
  private DeletePictureCommand delegate;
}
