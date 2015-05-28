package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.DevicePMSpecificationListPresenterService")
public interface DevicePMSpecificationListPresenterService extends RemoteService {
  public abstract Collection<UIDevicePMSpecification> loadDevicePMSpecificationList(final RCDeviceProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
