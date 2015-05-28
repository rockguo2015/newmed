package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryAddedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ProductCategoryAddedEvent extends GwtEvent<ProductCategoryAddedHandler> {
  public static Type<ProductCategoryAddedHandler> __type__ = new Type<ProductCategoryAddedHandler>();
  
  public Type<ProductCategoryAddedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ProductCategoryAddedHandler handler) {
    handler.ProductCategoryAdded(org);
  }
  
  private RCProductCategoryProxy org;
  
  public ProductCategoryAddedEvent(final RCProductCategoryProxy org) {
    this.org=org;
    
  }
}
