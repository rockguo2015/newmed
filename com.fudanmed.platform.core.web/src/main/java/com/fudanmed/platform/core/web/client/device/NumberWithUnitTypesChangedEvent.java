package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.NumberWithUnitTypesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class NumberWithUnitTypesChangedEvent extends GwtEvent<NumberWithUnitTypesChangedHandler> {
  public static Type<NumberWithUnitTypesChangedHandler> __type__ = new Type<NumberWithUnitTypesChangedHandler>();
  
  public Type<NumberWithUnitTypesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final NumberWithUnitTypesChangedHandler handler) {
    handler.NumberWithUnitTypesChanged();
  }
  
  public NumberWithUnitTypesChangedEvent() {
    
  }
}
