package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.OnsitePositionsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class OnsitePositionsChangedEvent extends GwtEvent<OnsitePositionsChangedHandler> {
  public static Type<OnsitePositionsChangedHandler> __type__ = new Type<OnsitePositionsChangedHandler>();
  
  public Type<OnsitePositionsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final OnsitePositionsChangedHandler handler) {
    handler.OnsitePositionsChanged();
  }
  
  public OnsitePositionsChangedEvent() {
    
  }
}
