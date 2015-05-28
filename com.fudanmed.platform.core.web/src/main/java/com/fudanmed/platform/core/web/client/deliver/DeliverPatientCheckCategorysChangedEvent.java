package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategorysChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DeliverPatientCheckCategorysChangedEvent extends GwtEvent<DeliverPatientCheckCategorysChangedHandler> {
  public static Type<DeliverPatientCheckCategorysChangedHandler> __type__ = new Type<DeliverPatientCheckCategorysChangedHandler>();
  
  public Type<DeliverPatientCheckCategorysChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DeliverPatientCheckCategorysChangedHandler handler) {
    handler.DeliverPatientCheckCategorysChanged();
  }
  
  public DeliverPatientCheckCategorysChangedEvent() {
    
  }
}
