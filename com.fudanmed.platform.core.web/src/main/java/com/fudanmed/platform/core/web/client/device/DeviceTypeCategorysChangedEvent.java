package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DeviceTypeCategorysChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DeviceTypeCategorysChangedEvent extends GwtEvent<DeviceTypeCategorysChangedHandler> {
  public static Type<DeviceTypeCategorysChangedHandler> __type__ = new Type<DeviceTypeCategorysChangedHandler>();
  
  public Type<DeviceTypeCategorysChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DeviceTypeCategorysChangedHandler handler) {
    handler.DeviceTypeCategorysChanged();
  }
  
  public DeviceTypeCategorysChangedEvent() {
    
  }
}
