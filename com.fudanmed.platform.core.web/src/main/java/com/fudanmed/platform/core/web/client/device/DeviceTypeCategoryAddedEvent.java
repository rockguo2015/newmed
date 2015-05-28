package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryAddedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DeviceTypeCategoryAddedEvent extends GwtEvent<DeviceTypeCategoryAddedHandler> {
  public static Type<DeviceTypeCategoryAddedHandler> __type__ = new Type<DeviceTypeCategoryAddedHandler>();
  
  public Type<DeviceTypeCategoryAddedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DeviceTypeCategoryAddedHandler handler) {
    handler.DeviceTypeCategoryAdded(org);
  }
  
  private RCDeviceTypeCategoryProxy org;
  
  public DeviceTypeCategoryAddedEvent(final RCDeviceTypeCategoryProxy org) {
    this.org=org;
    
  }
}
