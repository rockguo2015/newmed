package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIElectricMeasureDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface ElectricMeasureDeviceListPresenterServiceAsync {
  public abstract void loadElectricMeasureDeviceList(final RCElectricMeasureDeviceTypeProxy context, final AsyncCallback<Collection<UIElectricMeasureDevice>> callback);
}
