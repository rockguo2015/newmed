package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCWaterMeasureDeviceProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteWaterMeasureDeviceCommandServiceAsync {
  public abstract void delete(final RCWaterMeasureDeviceProxy value, final AsyncCallback<Void> callback);
}
