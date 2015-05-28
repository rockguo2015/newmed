package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateWaterMeasureDevicePresenterServiceAsync {
  public abstract void loadValue(final RCWaterMeasureDeviceProxy pvalue, final AsyncCallback<UIWaterMeasureDevice> callback);
  
  public abstract void updateValue(final UIWaterMeasureDevice uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIWaterMeasureDevice uivalue, final RCWaterMeasureDeviceTypeProxy parent, final AsyncCallback<Void> callback);
}
