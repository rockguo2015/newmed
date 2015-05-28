package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatus;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIRepairTaskStatusContentProvider extends AbstractContentProvider<UIRepairTaskStatus> {
  private static ArrayList<UIRepairTaskStatus> contents = com.google.common.collect.Lists.newArrayList(
    						UIRepairTaskStatus.cancel,UIRepairTaskStatus.closed,UIRepairTaskStatus.newCreated,UIRepairTaskStatus.scheduled,UIRepairTaskStatus.wait4Close,UIRepairTaskStatus.wait4GroupTaskFinish,UIRepairTaskStatus.wait4SchedulerProcess
    					);;
  
  public Collection<UIRepairTaskStatus> getContents() {
    return contents;
  }
}
