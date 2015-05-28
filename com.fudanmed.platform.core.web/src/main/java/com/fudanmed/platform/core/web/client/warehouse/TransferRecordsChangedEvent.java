package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.TransferRecordsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class TransferRecordsChangedEvent extends GwtEvent<TransferRecordsChangedHandler> {
  public static Type<TransferRecordsChangedHandler> __type__ = new Type<TransferRecordsChangedHandler>();
  
  public Type<TransferRecordsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final TransferRecordsChangedHandler handler) {
    handler.TransferRecordsChanged();
  }
  
  public TransferRecordsChangedEvent() {
    
  }
}
