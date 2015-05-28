package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCriteria;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenterService")
public interface DeviceTypeManagementPresenterService extends RemoteService {
  public abstract IPagedResult<UIDeviceType> filter(final UIDeviceTypeCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCExtensiableEntityProxy loadEntityExtension(final RCDeviceTypeProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void deleteSlotAttribute(final RCAttributeSlotProxy slot) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void deleteChild(final RCDeviceTypeProxy child) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
