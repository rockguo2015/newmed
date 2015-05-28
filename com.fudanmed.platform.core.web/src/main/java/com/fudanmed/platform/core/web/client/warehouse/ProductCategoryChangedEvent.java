package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ProductCategoryChangedEvent extends GwtEvent<ProductCategoryChangedHandler> {
  public static Type<ProductCategoryChangedHandler> __type__ = new Type<ProductCategoryChangedHandler>();
  
  public Type<ProductCategoryChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ProductCategoryChangedHandler handler) {
    handler.ProductCategoryChanged(org);
  }
  
  private RCProductCategoryProxy org;
  
  public ProductCategoryChangedEvent(final RCProductCategoryProxy org) {
    this.org=org;
    
  }
}
