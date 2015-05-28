package com.fudanmed.platform.core.web.shared.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.google.gwt.user.client.rpc.IsSerializable;

public class AllOrgEmployeeContentProviderCriteria implements IsSerializable {
  private RCOrganizationProxy org;
  
  public RCOrganizationProxy getOrg() {
    return this.org;
  }
  
  public void setOrg(final RCOrganizationProxy org) {
    this.org = org;
  }
  
  public final static String P_Org = "org";
}
