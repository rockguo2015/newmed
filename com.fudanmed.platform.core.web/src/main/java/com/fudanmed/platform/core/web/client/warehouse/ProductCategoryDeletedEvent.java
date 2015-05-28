package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.client.warehouse.ProductCategoryDeletedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ProductCategoryDeletedEvent extends GwtEvent<ProductCategoryDeletedHandler> {
  public static Type<ProductCategoryDeletedHandler> __type__ = new Type<ProductCategoryDeletedHandler>();
  
  public Type<ProductCategoryDeletedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ProductCategoryDeletedHandler handler) {
    handler.ProductCategoryDeleted(org);
  }
  
  private RCProductCategoryProxy org;
  
  public ProductCategoryDeletedEvent(final RCProductCategoryProxy org) {
    this.org=org;
    
  }
}
