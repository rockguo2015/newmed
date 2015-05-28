package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMDeviceTypeEntryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreatePMDefaultIntervalAssociationCommandService")
public interface CreatePMDefaultIntervalAssociationCommandService extends RemoteService {
  public abstract RCPMDeviceTypeEntryProxy getRCPMDeviceTypeEntry(final RCDeviceTypeProxy deviceType) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
