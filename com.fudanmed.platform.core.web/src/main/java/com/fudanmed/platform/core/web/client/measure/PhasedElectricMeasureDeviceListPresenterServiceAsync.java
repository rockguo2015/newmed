package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIPhasedElectricMeasureDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface PhasedElectricMeasureDeviceListPresenterServiceAsync {
  public abstract void loadPhasedElectricMeasureDeviceList(final RCPhasedElectricMeasureDeviceTypeProxy context, final AsyncCallback<Collection<UIPhasedElectricMeasureDevice>> callback);
}
