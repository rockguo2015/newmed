package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DeviceTypeCategoryChangedEvent extends GwtEvent<DeviceTypeCategoryChangedHandler> {
  public static Type<DeviceTypeCategoryChangedHandler> __type__ = new Type<DeviceTypeCategoryChangedHandler>();
  
  public Type<DeviceTypeCategoryChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DeviceTypeCategoryChangedHandler handler) {
    handler.DeviceTypeCategoryChanged(org);
  }
  
  private RCDeviceTypeCategoryProxy org;
  
  public DeviceTypeCategoryChangedEvent(final RCDeviceTypeCategoryProxy org) {
    this.org=org;
    
  }
}
