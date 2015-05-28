package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductCategorysChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ProductCategorysChangedEvent extends GwtEvent<ProductCategorysChangedHandler> {
  public static Type<ProductCategorysChangedHandler> __type__ = new Type<ProductCategorysChangedHandler>();
  
  public Type<ProductCategorysChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ProductCategorysChangedHandler handler) {
    handler.ProductCategorysChanged();
  }
  
  public ProductCategorysChangedEvent() {
    
  }
}
