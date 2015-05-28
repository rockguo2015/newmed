package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategorysChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DeliverMaterialCategorysChangedEvent extends GwtEvent<DeliverMaterialCategorysChangedHandler> {
  public static Type<DeliverMaterialCategorysChangedHandler> __type__ = new Type<DeliverMaterialCategorysChangedHandler>();
  
  public Type<DeliverMaterialCategorysChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DeliverMaterialCategorysChangedHandler handler) {
    handler.DeliverMaterialCategorysChanged();
  }
  
  public DeliverMaterialCategorysChangedEvent() {
    
  }
}
