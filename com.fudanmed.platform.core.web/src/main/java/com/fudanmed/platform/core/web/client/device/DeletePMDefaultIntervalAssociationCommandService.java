package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDefaultIntervalAssociationProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.DeletePMDefaultIntervalAssociationCommandService")
public interface DeletePMDefaultIntervalAssociationCommandService extends RemoteService {
  public abstract void delete(final RCPMDefaultIntervalAssociationProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
