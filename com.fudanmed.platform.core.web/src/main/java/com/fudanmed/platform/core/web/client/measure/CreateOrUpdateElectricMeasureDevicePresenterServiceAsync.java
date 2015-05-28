package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateElectricMeasureDevicePresenterServiceAsync {
  public abstract void loadValue(final RCElectricMeasureDeviceProxy pvalue, final AsyncCallback<UIElectricMeasureDevice> callback);
  
  public abstract void updateValue(final UIElectricMeasureDevice uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIElectricMeasureDevice uivalue, final RCElectricMeasureDeviceTypeProxy parent, final AsyncCallback<Void> callback);
}
