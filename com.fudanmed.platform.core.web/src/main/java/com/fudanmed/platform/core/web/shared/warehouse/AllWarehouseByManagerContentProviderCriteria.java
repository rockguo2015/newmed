package com.fudanmed.platform.core.web.shared.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.google.gwt.user.client.rpc.IsSerializable;

public class AllWarehouseByManagerContentProviderCriteria implements IsSerializable {
  private RCEmployeeProxy employee;
  
  public RCEmployeeProxy getEmployee() {
    return this.employee;
  }
  
  public void setEmployee(final RCEmployeeProxy employee) {
    this.employee = employee;
  }
  
  public final static String P_Employee = "employee";
}
