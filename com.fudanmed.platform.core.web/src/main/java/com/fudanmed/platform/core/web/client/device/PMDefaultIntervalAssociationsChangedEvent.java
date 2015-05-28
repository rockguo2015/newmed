package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class PMDefaultIntervalAssociationsChangedEvent extends GwtEvent<PMDefaultIntervalAssociationsChangedHandler> {
  public static Type<PMDefaultIntervalAssociationsChangedHandler> __type__ = new Type<PMDefaultIntervalAssociationsChangedHandler>();
  
  public Type<PMDefaultIntervalAssociationsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final PMDefaultIntervalAssociationsChangedHandler handler) {
    handler.PMDefaultIntervalAssociationsChanged();
  }
  
  public PMDefaultIntervalAssociationsChangedEvent() {
    
  }
}
