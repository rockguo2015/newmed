package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.ElectricMeasureDeviceListPresenterService")
public interface ElectricMeasureDeviceListPresenterService extends RemoteService {
  public abstract Collection<UIElectricMeasureDevice> loadElectricMeasureDeviceList(final RCElectricMeasureDeviceTypeProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
