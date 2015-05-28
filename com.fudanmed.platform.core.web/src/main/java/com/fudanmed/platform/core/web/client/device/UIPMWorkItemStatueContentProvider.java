package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemStatue;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIPMWorkItemStatueContentProvider extends AbstractContentProvider<UIPMWorkItemStatue> {
  private static ArrayList<UIPMWorkItemStatue> contents = com.google.common.collect.Lists.newArrayList(
    						UIPMWorkItemStatue.executing,UIPMWorkItemStatue.finished,UIPMWorkItemStatue.partialExecuting,UIPMWorkItemStatue.planed,UIPMWorkItemStatue.ready4TeamFinishReport,UIPMWorkItemStatue.teamAssigned,UIPMWorkItemStatue.teamFinished
    					);;
  
  public Collection<UIPMWorkItemStatue> getContents() {
    return contents;
  }
}
