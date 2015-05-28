package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.InputNextSupplierHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InputNextSupplierEvent extends GwtEvent<InputNextSupplierHandler> {
  public static Type<InputNextSupplierHandler> __type__ = new Type<InputNextSupplierHandler>();
  
  public Type<InputNextSupplierHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InputNextSupplierHandler handler) {
    handler.InputNextSupplier();
  }
  
  public InputNextSupplierEvent() {
    
  }
}
