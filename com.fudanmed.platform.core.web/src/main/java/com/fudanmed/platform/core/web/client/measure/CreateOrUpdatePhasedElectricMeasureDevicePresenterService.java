package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureDevicePresenterService")
public interface CreateOrUpdatePhasedElectricMeasureDevicePresenterService extends RemoteService {
  public abstract UIPhasedElectricMeasureDevice loadValue(final RCPhasedElectricMeasureDeviceProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIPhasedElectricMeasureDevice uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UIPhasedElectricMeasureDevice uivalue, final RCPhasedElectricMeasureDeviceTypeProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
