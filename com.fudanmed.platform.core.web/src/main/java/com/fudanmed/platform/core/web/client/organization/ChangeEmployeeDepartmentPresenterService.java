package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.ChangeEmployeeDepartmentPresenterService")
public interface ChangeEmployeeDepartmentPresenterService extends RemoteService {
  public abstract void changeOrganization(final RCEmployeeProxy employee, final RCOrganizationProxy newOrg) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIOrganization getOrganization4Employee(final RCEmployeeProxy employee) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
