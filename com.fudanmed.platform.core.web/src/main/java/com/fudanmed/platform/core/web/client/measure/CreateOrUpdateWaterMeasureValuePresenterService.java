package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureValueProxy;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureValue;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.CreateOrUpdateWaterMeasureValuePresenterService")
public interface CreateOrUpdateWaterMeasureValuePresenterService extends RemoteService {
  public abstract UIWaterMeasureValue loadValue(final RCWaterMeasureValueProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIWaterMeasureValue uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UIWaterMeasureValue uivalue, final RCMeasureDeviceProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
