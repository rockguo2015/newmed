package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionAddedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class OnsitePositionAddedEvent extends GwtEvent<OnsitePositionAddedHandler> {
  public static Type<OnsitePositionAddedHandler> __type__ = new Type<OnsitePositionAddedHandler>();
  
  public Type<OnsitePositionAddedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final OnsitePositionAddedHandler handler) {
    handler.OnsitePositionAdded(org);
  }
  
  private RCOnsitePositionProxy org;
  
  public OnsitePositionAddedEvent(final RCOnsitePositionProxy org) {
    this.org=org;
    
  }
}
