package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.google.gwt.event.shared.EventHandler;

public interface DeviceTypeCategoryDeletedHandler extends EventHandler {
  public abstract void DeviceTypeCategoryDeleted(final RCDeviceTypeCategoryProxy org);
}
