package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DevicePropertyPresenterServiceAsync {
  public abstract void loadDeviceInfo(final RCDeviceProxy device, final AsyncCallback<UIDevice> callback);
}
