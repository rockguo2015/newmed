package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageSummarysChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ProductWarehouseStorageSummarysChangedEvent extends GwtEvent<ProductWarehouseStorageSummarysChangedHandler> {
  public static Type<ProductWarehouseStorageSummarysChangedHandler> __type__ = new Type<ProductWarehouseStorageSummarysChangedHandler>();
  
  public Type<ProductWarehouseStorageSummarysChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ProductWarehouseStorageSummarysChangedHandler handler) {
    handler.ProductWarehouseStorageSummarysChanged();
  }
  
  public ProductWarehouseStorageSummarysChangedEvent() {
    
  }
}
