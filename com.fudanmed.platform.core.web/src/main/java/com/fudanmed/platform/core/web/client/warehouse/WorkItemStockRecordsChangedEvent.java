package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.WorkItemStockRecordsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class WorkItemStockRecordsChangedEvent extends GwtEvent<WorkItemStockRecordsChangedHandler> {
  public static Type<WorkItemStockRecordsChangedHandler> __type__ = new Type<WorkItemStockRecordsChangedHandler>();
  
  public Type<WorkItemStockRecordsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final WorkItemStockRecordsChangedHandler handler) {
    handler.WorkItemStockRecordsChanged();
  }
  
  public WorkItemStockRecordsChangedEvent() {
    
  }
}
