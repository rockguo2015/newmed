package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCNumberWithUnitTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UINumberWithUnitType;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.CreateOrUpdateNumberWithUnitTypePresenterService")
public interface CreateOrUpdateNumberWithUnitTypePresenterService extends RemoteService {
  public abstract UINumberWithUnitType loadValue(final RCNumberWithUnitTypeProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UINumberWithUnitType uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UINumberWithUnitType uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
