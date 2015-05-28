package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ChangeEmployeeDepartmentPresenterServiceAsync {
  public abstract void changeOrganization(final RCEmployeeProxy employee, final RCOrganizationProxy newOrg, final AsyncCallback<Void> callback);
  
  public abstract void getOrganization4Employee(final RCEmployeeProxy employee, final AsyncCallback<UIOrganization> callback);
}
