package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class OnsitePositionChangedEvent extends GwtEvent<OnsitePositionChangedHandler> {
  public static Type<OnsitePositionChangedHandler> __type__ = new Type<OnsitePositionChangedHandler>();
  
  public Type<OnsitePositionChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final OnsitePositionChangedHandler handler) {
    handler.OnsitePositionChanged(org);
  }
  
  private RCOnsitePositionProxy org;
  
  public OnsitePositionChangedEvent(final RCOnsitePositionProxy org) {
    this.org=org;
    
  }
}
