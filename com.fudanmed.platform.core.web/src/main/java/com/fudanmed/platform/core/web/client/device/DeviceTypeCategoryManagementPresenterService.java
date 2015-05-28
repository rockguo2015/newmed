package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementPresenterService")
public interface DeviceTypeCategoryManagementPresenterService extends RemoteService {
  public abstract Collection<UIDeviceTypeCategory> loadAllDeviceTypeCategory() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCDeviceTypeCategoryProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UIDeviceTypeCategory getValue(final RCDeviceTypeCategoryProxy org) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIDeviceType> loadItems(final RCDeviceTypeCategoryProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void deleteChild(final RCDeviceTypeProxy child) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
