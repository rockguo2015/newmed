package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryDeletedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DeviceTypeCategoryDeletedEvent extends GwtEvent<DeviceTypeCategoryDeletedHandler> {
  public static Type<DeviceTypeCategoryDeletedHandler> __type__ = new Type<DeviceTypeCategoryDeletedHandler>();
  
  public Type<DeviceTypeCategoryDeletedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DeviceTypeCategoryDeletedHandler handler) {
    handler.DeviceTypeCategoryDeleted(org);
  }
  
  private RCDeviceTypeCategoryProxy org;
  
  public DeviceTypeCategoryDeletedEvent(final RCDeviceTypeCategoryProxy org) {
    this.org=org;
    
  }
}
