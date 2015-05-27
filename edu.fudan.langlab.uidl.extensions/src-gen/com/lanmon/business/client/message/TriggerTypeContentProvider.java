package com.lanmon.business.client.message;

import com.lanmon.business.shared.message.TriggerType;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class TriggerTypeContentProvider extends AbstractContentProvider<TriggerType> {
  private static ArrayList<TriggerType> contents = com.google.common.collect.Lists.newArrayList(
    						TriggerType.OneTime,TriggerType.Periodic,TriggerType.ContractDate,TriggerType.OutSourceDate
    					);;
  
  public Collection<TriggerType> getContents() {
    return contents;
  }
}
