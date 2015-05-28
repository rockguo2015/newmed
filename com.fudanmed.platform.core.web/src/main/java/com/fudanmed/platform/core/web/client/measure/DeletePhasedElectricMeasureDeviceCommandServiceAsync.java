package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCPhasedElectricMeasureDeviceProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeletePhasedElectricMeasureDeviceCommandServiceAsync {
  public abstract void delete(final RCPhasedElectricMeasureDeviceProxy value, final AsyncCallback<Void> callback);
}
