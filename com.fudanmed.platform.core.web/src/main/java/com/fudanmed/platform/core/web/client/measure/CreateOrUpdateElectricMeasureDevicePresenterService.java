package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.CreateOrUpdateElectricMeasureDevicePresenterService")
public interface CreateOrUpdateElectricMeasureDevicePresenterService extends RemoteService {
  public abstract UIElectricMeasureDevice loadValue(final RCElectricMeasureDeviceProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIElectricMeasureDevice uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UIElectricMeasureDevice uivalue, final RCElectricMeasureDeviceTypeProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
