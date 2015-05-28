package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIGasMeasureDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateGasMeasureDevicePresenterServiceAsync {
  public abstract void loadValue(final RCGasMeasureDeviceProxy pvalue, final AsyncCallback<UIGasMeasureDevice> callback);
  
  public abstract void updateValue(final UIGasMeasureDevice uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIGasMeasureDevice uivalue, final RCGasMeasureDeviceTypeProxy parent, final AsyncCallback<Void> callback);
}
