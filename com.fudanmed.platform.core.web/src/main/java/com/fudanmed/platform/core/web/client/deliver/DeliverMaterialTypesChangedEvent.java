package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DeliverMaterialTypesChangedEvent extends GwtEvent<DeliverMaterialTypesChangedHandler> {
  public static Type<DeliverMaterialTypesChangedHandler> __type__ = new Type<DeliverMaterialTypesChangedHandler>();
  
  public Type<DeliverMaterialTypesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DeliverMaterialTypesChangedHandler handler) {
    handler.DeliverMaterialTypesChanged();
  }
  
  public DeliverMaterialTypesChangedEvent() {
    
  }
}
