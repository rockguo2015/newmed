package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureValueProxy;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureValue;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.CreateOrUpdatePhasedElectricMeasureValuePresenterService")
public interface CreateOrUpdatePhasedElectricMeasureValuePresenterService extends RemoteService {
  public abstract UIPhasedElectricMeasureValue loadValue(final RCPhasedElectricMeasureValueProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIPhasedElectricMeasureValue uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UIPhasedElectricMeasureValue uivalue, final RCMeasureDeviceProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
