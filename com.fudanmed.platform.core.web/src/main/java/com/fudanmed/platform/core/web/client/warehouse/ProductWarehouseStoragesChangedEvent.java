package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStoragesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ProductWarehouseStoragesChangedEvent extends GwtEvent<ProductWarehouseStoragesChangedHandler> {
  public static Type<ProductWarehouseStoragesChangedHandler> __type__ = new Type<ProductWarehouseStoragesChangedHandler>();
  
  public Type<ProductWarehouseStoragesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ProductWarehouseStoragesChangedHandler handler) {
    handler.ProductWarehouseStoragesChanged();
  }
  
  public ProductWarehouseStoragesChangedEvent() {
    
  }
}
