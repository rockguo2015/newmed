package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIWaterMeasureDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WaterMeasureDeviceListPresenterServiceAsync {
  public abstract void loadWaterMeasureDeviceList(final RCWaterMeasureDeviceTypeProxy context, final AsyncCallback<Collection<UIWaterMeasureDevice>> callback);
}
