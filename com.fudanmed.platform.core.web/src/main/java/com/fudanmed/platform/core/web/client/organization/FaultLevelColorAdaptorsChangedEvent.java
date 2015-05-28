package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.FaultLevelColorAdaptorsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class FaultLevelColorAdaptorsChangedEvent extends GwtEvent<FaultLevelColorAdaptorsChangedHandler> {
  public static Type<FaultLevelColorAdaptorsChangedHandler> __type__ = new Type<FaultLevelColorAdaptorsChangedHandler>();
  
  public Type<FaultLevelColorAdaptorsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final FaultLevelColorAdaptorsChangedHandler handler) {
    handler.FaultLevelColorAdaptorsChanged();
  }
  
  public FaultLevelColorAdaptorsChangedEvent() {
    
  }
}
