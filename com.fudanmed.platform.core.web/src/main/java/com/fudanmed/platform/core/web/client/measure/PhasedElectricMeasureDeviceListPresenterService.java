package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.PhasedElectricMeasureDeviceListPresenterService")
public interface PhasedElectricMeasureDeviceListPresenterService extends RemoteService {
  public abstract Collection<UIPhasedElectricMeasureDevice> loadPhasedElectricMeasureDeviceList(final RCPhasedElectricMeasureDeviceTypeProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
