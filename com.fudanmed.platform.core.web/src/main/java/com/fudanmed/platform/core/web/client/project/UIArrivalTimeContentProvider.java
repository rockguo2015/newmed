package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIArrivalTime;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class UIArrivalTimeContentProvider extends AbstractContentProvider<UIArrivalTime> {
  private static ArrayList<UIArrivalTime> contents = com.google.common.collect.Lists.newArrayList(
    						UIArrivalTime.bad,UIArrivalTime.good,UIArrivalTime.normal
    					);;
  
  public Collection<UIArrivalTime> getContents() {
    return contents;
  }
}
