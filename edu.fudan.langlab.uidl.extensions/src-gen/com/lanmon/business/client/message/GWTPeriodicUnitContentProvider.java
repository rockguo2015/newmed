package com.lanmon.business.client.message;

import com.lanmon.business.shared.message.GWTPeriodicUnit;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class GWTPeriodicUnitContentProvider extends AbstractContentProvider<GWTPeriodicUnit> {
  private static ArrayList<GWTPeriodicUnit> contents = com.google.common.collect.Lists.newArrayList(
    						GWTPeriodicUnit.Day,GWTPeriodicUnit.Week,GWTPeriodicUnit.Month
    					);;
  
  public Collection<GWTPeriodicUnit> getContents() {
    return contents;
  }
}
