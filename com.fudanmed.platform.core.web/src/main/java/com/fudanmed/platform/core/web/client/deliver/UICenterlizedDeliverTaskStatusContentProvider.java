package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTaskStatus;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UICenterlizedDeliverTaskStatusContentProvider extends AbstractContentProvider<UICenterlizedDeliverTaskStatus> {
  private static ArrayList<UICenterlizedDeliverTaskStatus> contents = com.google.common.collect.Lists.newArrayList(
    						UICenterlizedDeliverTaskStatus.canceled,UICenterlizedDeliverTaskStatus.dispatched,UICenterlizedDeliverTaskStatus.finished,UICenterlizedDeliverTaskStatus.scheduled
    					);;
  
  public Collection<UICenterlizedDeliverTaskStatus> getContents() {
    return contents;
  }
}
