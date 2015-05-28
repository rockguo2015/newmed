package com.fudanmed.platform.core.web.shared.organization;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.google.gwt.user.client.rpc.IsSerializable;

public class AllDeliverEmployeeContentProviderCriteria implements IsSerializable {
  private DLDeliverOrganizationProxy org;
  
  public DLDeliverOrganizationProxy getOrg() {
    return this.org;
  }
  
  public void setOrg(final DLDeliverOrganizationProxy org) {
    this.org = org;
  }
  
  public final static String P_Org = "org";
}
