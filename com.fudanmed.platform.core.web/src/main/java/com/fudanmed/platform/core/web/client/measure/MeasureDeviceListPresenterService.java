package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.MeasureDeviceListPresenterService")
public interface MeasureDeviceListPresenterService extends RemoteService {
  public abstract Collection<UIMeasureDevice> loadMeasureDeviceList(final RCMeasureDeviceTypeProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
