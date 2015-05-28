package com.fudanmed.platform.core.web.client.device;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.PopulatePMPlantoAllDeviceCommandService")
public interface PopulatePMPlantoAllDeviceCommandService extends RemoteService {
  public abstract void populateAll() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
