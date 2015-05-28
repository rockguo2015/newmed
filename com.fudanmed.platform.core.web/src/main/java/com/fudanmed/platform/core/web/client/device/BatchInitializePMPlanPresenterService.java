package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.BatchInitializePMPlanData;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.BatchInitializePMPlanPresenterService")
public interface BatchInitializePMPlanPresenterService extends RemoteService {
  public abstract void init4Device(final UIDeviceCriteria deviceCriteria, final BatchInitializePMPlanData data) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
