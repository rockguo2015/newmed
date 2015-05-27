package com.lanmon.business.client.customer;

import com.lanmon.business.shared.customer.GWTCustomerStatus;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractContentProvider;
import java.util.ArrayList;
import java.util.Collection;

public class GWTCustomerStatusContentProvider extends AbstractContentProvider<GWTCustomerStatus> {
  private static ArrayList<GWTCustomerStatus> contents = com.google.common.collect.Lists.newArrayList(
    						GWTCustomerStatus.normal,GWTCustomerStatus.tracking,GWTCustomerStatus.intended,GWTCustomerStatus.onsite,GWTCustomerStatus.contracted,GWTCustomerStatus.decontracted
    					);;
  
  public Collection<GWTCustomerStatus> getContents() {
    return contents;
  }
}
