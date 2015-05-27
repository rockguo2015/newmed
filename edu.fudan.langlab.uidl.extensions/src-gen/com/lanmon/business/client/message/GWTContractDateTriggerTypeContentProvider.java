package com.lanmon.business.client.message;

import com.lanmon.business.shared.message.GWTContractDateTriggerType;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class GWTContractDateTriggerTypeContentProvider extends AbstractContentProvider<GWTContractDateTriggerType> {
  private static ArrayList<GWTContractDateTriggerType> contents = com.google.common.collect.Lists.newArrayList(
    						GWTContractDateTriggerType.OnStart,GWTContractDateTriggerType.OnFinish
    					);;
  
  public Collection<GWTContractDateTriggerType> getContents() {
    return contents;
  }
}
