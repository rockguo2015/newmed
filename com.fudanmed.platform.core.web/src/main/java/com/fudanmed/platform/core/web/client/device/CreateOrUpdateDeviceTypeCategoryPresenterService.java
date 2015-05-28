package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreateOrUpdateDeviceTypeCategoryPresenterService")
public interface CreateOrUpdateDeviceTypeCategoryPresenterService extends RemoteService {
  public abstract UIDeviceTypeCategory loadValue(final RCDeviceTypeCategoryProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIDeviceTypeCategory uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract RCDeviceTypeCategoryProxy createValue(final UIDeviceTypeCategory uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
