package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductTypesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ProductTypesChangedEvent extends GwtEvent<ProductTypesChangedHandler> {
  public static Type<ProductTypesChangedHandler> __type__ = new Type<ProductTypesChangedHandler>();
  
  public Type<ProductTypesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ProductTypesChangedHandler handler) {
    handler.ProductTypesChanged();
  }
  
  public ProductTypesChangedEvent() {
    
  }
}
