package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.SuppliersChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SuppliersChangedEvent extends GwtEvent<SuppliersChangedHandler> {
  public static Type<SuppliersChangedHandler> __type__ = new Type<SuppliersChangedHandler>();
  
  public Type<SuppliersChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final SuppliersChangedHandler handler) {
    handler.SuppliersChanged();
  }
  
  public SuppliersChangedEvent() {
    
  }
}
