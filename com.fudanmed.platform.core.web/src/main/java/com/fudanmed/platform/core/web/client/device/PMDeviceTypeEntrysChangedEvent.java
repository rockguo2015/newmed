package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMDeviceTypeEntrysChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class PMDeviceTypeEntrysChangedEvent extends GwtEvent<PMDeviceTypeEntrysChangedHandler> {
  public static Type<PMDeviceTypeEntrysChangedHandler> __type__ = new Type<PMDeviceTypeEntrysChangedHandler>();
  
  public Type<PMDeviceTypeEntrysChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final PMDeviceTypeEntrysChangedHandler handler) {
    handler.PMDeviceTypeEntrysChanged();
  }
  
  public PMDeviceTypeEntrysChangedEvent() {
    
  }
}
