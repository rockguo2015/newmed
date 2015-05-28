package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenterService")
public interface OrganizationOutlinePresenterService extends RemoteService {
  public abstract Collection<UIOrganization> loadAllOrganization() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIOrganization getValue(final RCOrganizationProxy org) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
