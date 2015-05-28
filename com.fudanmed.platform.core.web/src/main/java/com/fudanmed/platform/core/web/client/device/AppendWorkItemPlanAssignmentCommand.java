package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.command.BaseContextAwareSingleObjectCommand;
import com.uniquesoft.gwt.shared.command.IContextConsumer;
import edu.fudan.langlab.gxt.client.widget.IWidgetFactory;

public class AppendWorkItemPlanAssignmentCommand extends BaseContextAwareSingleObjectCommand<RCPMWorkItemProxy> implements IContextConsumer<RCPMWorkItemProxy> {
  @Inject
  private IWidgetFactory widgets;
  
  public String getTitle() {
    return "维保设备";
  }
  
  public String getActionId() {
    return "com.fudanmed.platform.core.web.AppendWorkItemPlanAssignmentCommand";
  }
  
  public boolean requireCheck() {
    return false;
  }
  
  public void execute(final RCPMWorkItemProxy value) {
  }
}
