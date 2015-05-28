package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.shared.device.InitializePMPlanData;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Date;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.InitializePMPlanPresenterService")
public interface InitializePMPlanPresenterService extends RemoteService {
  public abstract void init4Device(final InitializePMPlanData data, final RCDevicePMSpecificationProxy devicePMSpec) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Date loadDefaultFromDate(final RCDevicePMSpecificationProxy devicePMSpec) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
