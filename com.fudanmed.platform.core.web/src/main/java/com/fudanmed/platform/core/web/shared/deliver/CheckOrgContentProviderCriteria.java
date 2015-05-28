package com.fudanmed.platform.core.web.shared.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.google.gwt.user.client.rpc.IsSerializable;

public class CheckOrgContentProviderCriteria implements IsSerializable {
  private DLDeliverPatientCheckTypeProxy checkType;
  
  public DLDeliverPatientCheckTypeProxy getCheckType() {
    return this.checkType;
  }
  
  public void setCheckType(final DLDeliverPatientCheckTypeProxy checkType) {
    this.checkType = checkType;
  }
  
  public final static String P_CheckType = "checkType";
}
