package com.lanmon.business.shared.customer;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.IObjectNameFilter;

public class CustomerContentProviderCriteria implements IsSerializable, IObjectNameFilter {
  private String name;
  
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  public final static String P_Name = "name";
}
