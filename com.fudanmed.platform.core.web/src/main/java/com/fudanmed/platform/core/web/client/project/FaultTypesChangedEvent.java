package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.FaultTypesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class FaultTypesChangedEvent extends GwtEvent<FaultTypesChangedHandler> {
  public static Type<FaultTypesChangedHandler> __type__ = new Type<FaultTypesChangedHandler>();
  
  public Type<FaultTypesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final FaultTypesChangedHandler handler) {
    handler.FaultTypesChanged();
  }
  
  public FaultTypesChangedEvent() {
    
  }
}
