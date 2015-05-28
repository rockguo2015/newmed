package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.WaterMeasureDeviceListPresenterService")
public interface WaterMeasureDeviceListPresenterService extends RemoteService {
  public abstract Collection<UIWaterMeasureDevice> loadWaterMeasureDeviceList(final RCWaterMeasureDeviceTypeProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
