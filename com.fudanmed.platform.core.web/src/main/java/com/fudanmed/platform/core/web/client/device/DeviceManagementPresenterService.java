package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.DeviceManagementPresenterService")
public interface DeviceManagementPresenterService extends RemoteService {
  public abstract IPagedResult<UIDevice> filter(final UIDeviceCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCDeviceProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCExtensiableEntityProxy loadEntityExtension(final RCDeviceProxy device) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
