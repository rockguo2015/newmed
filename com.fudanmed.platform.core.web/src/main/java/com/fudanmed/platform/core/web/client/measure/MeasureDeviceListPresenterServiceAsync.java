package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.measure.UIMeasureDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface MeasureDeviceListPresenterServiceAsync {
  public abstract void loadMeasureDeviceList(final RCMeasureDeviceTypeProxy context, final AsyncCallback<Collection<UIMeasureDevice>> callback);
}
