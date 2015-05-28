package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypePresenterService")
public interface CreateOrUpdateDeviceTypePresenterService extends RemoteService {
  public abstract UIDeviceType loadValue(final RCDeviceTypeProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIDeviceType uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValueWithClone(final RCDeviceTypeCategoryProxy categoryType, final RCDeviceTypeProxy cloneSource, final UIDeviceType uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final RCDeviceTypeCategoryProxy categoryType, final UIDeviceType uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCDeviceTypeCategoryProxy loadCategory(final RCDeviceTypeProxy deviceType) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
