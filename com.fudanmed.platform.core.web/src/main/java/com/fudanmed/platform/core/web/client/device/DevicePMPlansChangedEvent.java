package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DevicePMPlansChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DevicePMPlansChangedEvent extends GwtEvent<DevicePMPlansChangedHandler> {
  public static Type<DevicePMPlansChangedHandler> __type__ = new Type<DevicePMPlansChangedHandler>();
  
  public Type<DevicePMPlansChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DevicePMPlansChangedHandler handler) {
    handler.DevicePMPlansChanged();
  }
  
  public DevicePMPlansChangedEvent() {
    
  }
}
