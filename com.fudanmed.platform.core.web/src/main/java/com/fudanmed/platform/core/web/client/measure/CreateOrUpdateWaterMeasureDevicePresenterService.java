package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureDevicePresenterService")
public interface CreateOrUpdateWaterMeasureDevicePresenterService extends RemoteService {
  public abstract UIWaterMeasureDevice loadValue(final RCWaterMeasureDeviceProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIWaterMeasureDevice uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UIWaterMeasureDevice uivalue, final RCWaterMeasureDeviceTypeProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
