package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMDeviceTypeEntry;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMDeviceTypeEntryPresenterService")
public interface CreateOrUpdatePMDeviceTypeEntryPresenterService extends RemoteService {
  public abstract UIPMDeviceTypeEntry loadValue(final RCDeviceTypeProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIPMDeviceTypeEntry uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
