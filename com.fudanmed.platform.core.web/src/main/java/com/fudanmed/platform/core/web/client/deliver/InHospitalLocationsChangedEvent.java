package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.InHospitalLocationsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InHospitalLocationsChangedEvent extends GwtEvent<InHospitalLocationsChangedHandler> {
  public static Type<InHospitalLocationsChangedHandler> __type__ = new Type<InHospitalLocationsChangedHandler>();
  
  public Type<InHospitalLocationsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InHospitalLocationsChangedHandler handler) {
    handler.InHospitalLocationsChanged();
  }
  
  public InHospitalLocationsChangedEvent() {
    
  }
}
