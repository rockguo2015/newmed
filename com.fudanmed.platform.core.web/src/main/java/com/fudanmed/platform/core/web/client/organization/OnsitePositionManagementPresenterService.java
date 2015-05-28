package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.OnsitePositionManagementPresenterService")
public interface OnsitePositionManagementPresenterService extends RemoteService {
  public abstract void delete(final RCOnsitePositionProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
