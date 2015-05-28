package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.StockTakingRecordsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class StockTakingRecordsChangedEvent extends GwtEvent<StockTakingRecordsChangedHandler> {
  public static Type<StockTakingRecordsChangedHandler> __type__ = new Type<StockTakingRecordsChangedHandler>();
  
  public Type<StockTakingRecordsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final StockTakingRecordsChangedHandler handler) {
    handler.StockTakingRecordsChanged();
  }
  
  public StockTakingRecordsChangedEvent() {
    
  }
}
