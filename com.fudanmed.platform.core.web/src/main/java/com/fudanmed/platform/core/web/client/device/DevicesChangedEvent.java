package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DevicesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DevicesChangedEvent extends GwtEvent<DevicesChangedHandler> {
  public static Type<DevicesChangedHandler> __type__ = new Type<DevicesChangedHandler>();
  
  public Type<DevicesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DevicesChangedHandler handler) {
    handler.DevicesChanged();
  }
  
  public DevicesChangedEvent() {
    
  }
}
