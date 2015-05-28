package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.InStockRecordsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InStockRecordsChangedEvent extends GwtEvent<InStockRecordsChangedHandler> {
  public static Type<InStockRecordsChangedHandler> __type__ = new Type<InStockRecordsChangedHandler>();
  
  public Type<InStockRecordsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InStockRecordsChangedHandler handler) {
    handler.InStockRecordsChanged();
  }
  
  public InStockRecordsChangedEvent() {
    
  }
}
