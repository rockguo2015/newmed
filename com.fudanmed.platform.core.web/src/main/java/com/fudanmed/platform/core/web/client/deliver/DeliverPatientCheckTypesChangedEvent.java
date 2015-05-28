package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class DeliverPatientCheckTypesChangedEvent extends GwtEvent<DeliverPatientCheckTypesChangedHandler> {
  public static Type<DeliverPatientCheckTypesChangedHandler> __type__ = new Type<DeliverPatientCheckTypesChangedHandler>();
  
  public Type<DeliverPatientCheckTypesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final DeliverPatientCheckTypesChangedHandler handler) {
    handler.DeliverPatientCheckTypesChanged();
  }
  
  public DeliverPatientCheckTypesChangedEvent() {
    
  }
}
