package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.GasMeasureDeviceListPresenterService")
public interface GasMeasureDeviceListPresenterService extends RemoteService {
  public abstract Collection<UIGasMeasureDevice> loadGasMeasureDeviceList(final RCGasMeasureDeviceTypeProxy context) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
