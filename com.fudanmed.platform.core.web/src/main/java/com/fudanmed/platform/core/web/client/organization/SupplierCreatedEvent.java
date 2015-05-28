package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.client.organization.SupplierCreatedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SupplierCreatedEvent extends GwtEvent<SupplierCreatedHandler> {
  public static Type<SupplierCreatedHandler> __type__ = new Type<SupplierCreatedHandler>();
  
  public Type<SupplierCreatedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final SupplierCreatedHandler handler) {
    handler.SupplierCreated(supplier);
  }
  
  private RCSupplierProxy supplier;
  
  public SupplierCreatedEvent(final RCSupplierProxy supplier) {
    this.supplier=supplier;
    
  }
}
