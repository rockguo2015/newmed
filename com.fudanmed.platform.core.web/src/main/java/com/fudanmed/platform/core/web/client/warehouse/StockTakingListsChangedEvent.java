package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.StockTakingListsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class StockTakingListsChangedEvent extends GwtEvent<StockTakingListsChangedHandler> {
  public static Type<StockTakingListsChangedHandler> __type__ = new Type<StockTakingListsChangedHandler>();
  
  public Type<StockTakingListsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final StockTakingListsChangedHandler handler) {
    handler.StockTakingListsChanged();
  }
  
  public StockTakingListsChangedEvent() {
    
  }
}
