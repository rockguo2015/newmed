package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.validation.ValidationException;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.measure.CreateOrUpdateGasMeasureDevicePresenterService")
public interface CreateOrUpdateGasMeasureDevicePresenterService extends RemoteService {
  public abstract UIGasMeasureDevice loadValue(final RCGasMeasureDeviceProxy pvalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void updateValue(final UIGasMeasureDevice uivalue) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void createValue(final UIGasMeasureDevice uivalue, final RCGasMeasureDeviceTypeProxy parent) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
