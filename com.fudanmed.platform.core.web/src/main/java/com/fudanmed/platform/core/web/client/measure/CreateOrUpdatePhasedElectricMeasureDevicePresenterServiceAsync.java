package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdatePhasedElectricMeasureDevicePresenterServiceAsync {
  public abstract void loadValue(final RCPhasedElectricMeasureDeviceProxy pvalue, final AsyncCallback<UIPhasedElectricMeasureDevice> callback);
  
  public abstract void updateValue(final UIPhasedElectricMeasureDevice uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIPhasedElectricMeasureDevice uivalue, final RCPhasedElectricMeasureDeviceTypeProxy parent, final AsyncCallback<Void> callback);
}
