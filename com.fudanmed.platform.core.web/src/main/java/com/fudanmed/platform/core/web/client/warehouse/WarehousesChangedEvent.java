package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.WarehousesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class WarehousesChangedEvent extends GwtEvent<WarehousesChangedHandler> {
  public static Type<WarehousesChangedHandler> __type__ = new Type<WarehousesChangedHandler>();
  
  public Type<WarehousesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final WarehousesChangedHandler handler) {
    handler.WarehousesChanged();
  }
  
  public WarehousesChangedEvent() {
    
  }
}
