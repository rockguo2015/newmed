package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.google.gwt.event.shared.EventHandler;

public interface DeviceTypeCategoryAddedHandler extends EventHandler {
  public abstract void DeviceTypeCategoryAdded(final RCDeviceTypeCategoryProxy org);
}
