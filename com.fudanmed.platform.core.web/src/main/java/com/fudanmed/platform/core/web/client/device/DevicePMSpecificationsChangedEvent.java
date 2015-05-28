package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DevicePMSpecificationsChangedEvent extends GwtEvent<DevicePMSpecificationsChangedHandler> {
  public static Type<DevicePMSpecificationsChangedHandler> __type__ = new Type<DevicePMSpecificationsChangedHandler>();
  
  public Type<DevicePMSpecificationsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DevicePMSpecificationsChangedHandler handler) {
    handler.DevicePMSpecificationsChanged();
  }
  
  public DevicePMSpecificationsChangedEvent() {
    
  }
}
