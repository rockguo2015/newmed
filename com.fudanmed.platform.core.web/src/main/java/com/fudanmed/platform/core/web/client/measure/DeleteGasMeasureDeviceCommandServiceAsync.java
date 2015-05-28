package com.fudanmed.platform.core.web.client.measure;

import com.fudanmed.platform.core.measure.proxy.RCGasMeasureDeviceProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteGasMeasureDeviceCommandServiceAsync {
  public abstract void delete(final RCGasMeasureDeviceProxy value, final AsyncCallback<Void> callback);
}
