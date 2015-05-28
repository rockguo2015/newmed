package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InHospitalPatientsChangedEvent extends GwtEvent<InHospitalPatientsChangedHandler> {
  public static Type<InHospitalPatientsChangedHandler> __type__ = new Type<InHospitalPatientsChangedHandler>();
  
  public Type<InHospitalPatientsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InHospitalPatientsChangedHandler handler) {
    handler.InHospitalPatientsChanged();
  }
  
  public InHospitalPatientsChangedEvent() {
    
  }
}
