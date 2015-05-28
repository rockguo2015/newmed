package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ProductStoreTransactionsChangedEvent extends GwtEvent<ProductStoreTransactionsChangedHandler> {
  public static Type<ProductStoreTransactionsChangedHandler> __type__ = new Type<ProductStoreTransactionsChangedHandler>();
  
  public Type<ProductStoreTransactionsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ProductStoreTransactionsChangedHandler handler) {
    handler.ProductStoreTransactionsChanged();
  }
  
  public ProductStoreTransactionsChangedEvent() {
    
  }
}
