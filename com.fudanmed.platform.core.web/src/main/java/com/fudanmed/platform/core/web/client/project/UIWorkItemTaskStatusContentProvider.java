package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemTaskStatus;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIWorkItemTaskStatusContentProvider extends AbstractContentProvider<UIWorkItemTaskStatus> {
  private static ArrayList<UIWorkItemTaskStatus> contents = com.google.common.collect.Lists.newArrayList(
    						UIWorkItemTaskStatus.canceled,UIWorkItemTaskStatus.finished,UIWorkItemTaskStatus.followuping,UIWorkItemTaskStatus.misDispatching,UIWorkItemTaskStatus.outsourceFinish,UIWorkItemTaskStatus.outsourcing,UIWorkItemTaskStatus.pendFinish,UIWorkItemTaskStatus.pending,UIWorkItemTaskStatus.processing
    					);;
  
  public Collection<UIWorkItemTaskStatus> getContents() {
    return contents;
  }
}
