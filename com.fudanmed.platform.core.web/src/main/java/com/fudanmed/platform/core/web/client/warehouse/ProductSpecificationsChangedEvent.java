package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ProductSpecificationsChangedEvent extends GwtEvent<ProductSpecificationsChangedHandler> {
  public static Type<ProductSpecificationsChangedHandler> __type__ = new Type<ProductSpecificationsChangedHandler>();
  
  public Type<ProductSpecificationsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ProductSpecificationsChangedHandler handler) {
    handler.ProductSpecificationsChanged();
  }
  
  public ProductSpecificationsChangedEvent() {
    
  }
}
