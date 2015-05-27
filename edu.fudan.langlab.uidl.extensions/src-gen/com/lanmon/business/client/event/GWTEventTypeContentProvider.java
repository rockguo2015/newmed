package com.lanmon.business.client.event;

import com.lanmon.business.shared.event.GWTEventType;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class GWTEventTypeContentProvider extends AbstractContentProvider<GWTEventType> {
  private static ArrayList<GWTEventType> contents = com.google.common.collect.Lists.newArrayList(
    						GWTEventType.PhoneCall,GWTEventType.Visit,GWTEventType.Meeting,GWTEventType.Normal
    					);;
  
  public Collection<GWTEventType> getContents() {
    return contents;
  }
}
