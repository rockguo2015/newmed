package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCElectricMeasureDeviceProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteElectricMeasureDeviceCommandServiceAsync {
  public abstract void delete(final RCElectricMeasureDeviceProxy value, final AsyncCallback<Void> callback);
}
