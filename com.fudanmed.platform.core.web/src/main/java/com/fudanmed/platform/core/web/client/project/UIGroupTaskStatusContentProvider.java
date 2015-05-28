package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatus;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIGroupTaskStatusContentProvider extends AbstractContentProvider<UIGroupTaskStatus> {
  private static ArrayList<UIGroupTaskStatus> contents = com.google.common.collect.Lists.newArrayList(
    						UIGroupTaskStatus.canceled,UIGroupTaskStatus.finished,UIGroupTaskStatus.misDispatched,UIGroupTaskStatus.newCreated,UIGroupTaskStatus.wait4TasksFinish,UIGroupTaskStatus.wait4TeamOwnerProcess
    					);;
  
  public Collection<UIGroupTaskStatus> getContents() {
    return contents;
  }
}
