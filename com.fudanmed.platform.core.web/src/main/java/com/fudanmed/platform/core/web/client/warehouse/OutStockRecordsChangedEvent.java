package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.OutStockRecordsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class OutStockRecordsChangedEvent extends GwtEvent<OutStockRecordsChangedHandler> {
  public static Type<OutStockRecordsChangedHandler> __type__ = new Type<OutStockRecordsChangedHandler>();
  
  public Type<OutStockRecordsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final OutStockRecordsChangedHandler handler) {
    handler.OutStockRecordsChanged();
  }
  
  public OutStockRecordsChangedEvent() {
    
  }
}
