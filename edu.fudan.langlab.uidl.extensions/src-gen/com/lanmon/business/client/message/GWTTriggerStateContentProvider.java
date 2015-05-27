package com.lanmon.business.client.message;

import com.lanmon.business.shared.message.GWTTriggerState;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class GWTTriggerStateContentProvider extends AbstractContentProvider<GWTTriggerState> {
  private static ArrayList<GWTTriggerState> contents = com.google.common.collect.Lists.newArrayList(
    						GWTTriggerState.Waiting,GWTTriggerState.Triggled,GWTTriggerState.Stopped
    					);;
  
  public Collection<GWTTriggerState> getContents() {
    return contents;
  }
}
