package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemWorkerAssignmentStatus;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIPMWorkItemWorkerAssignmentStatusContentProvider extends AbstractContentProvider<UIPMWorkItemWorkerAssignmentStatus> {
  private static ArrayList<UIPMWorkItemWorkerAssignmentStatus> contents = com.google.common.collect.Lists.newArrayList(
    						UIPMWorkItemWorkerAssignmentStatus.finished,UIPMWorkItemWorkerAssignmentStatus.pending,UIPMWorkItemWorkerAssignmentStatus.planed
    					);;
  
  public Collection<UIPMWorkItemWorkerAssignmentStatus> getContents() {
    return contents;
  }
}
