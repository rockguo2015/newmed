package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DeviceTypesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DeviceTypesChangedEvent extends GwtEvent<DeviceTypesChangedHandler> {
  public static Type<DeviceTypesChangedHandler> __type__ = new Type<DeviceTypesChangedHandler>();
  
  public Type<DeviceTypesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DeviceTypesChangedHandler handler) {
    handler.DeviceTypesChanged();
  }
  
  public DeviceTypesChangedEvent() {
    
  }
}
