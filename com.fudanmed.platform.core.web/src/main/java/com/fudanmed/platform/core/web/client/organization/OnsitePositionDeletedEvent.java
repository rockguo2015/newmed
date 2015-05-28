package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.OnsitePositionDeletedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class OnsitePositionDeletedEvent extends GwtEvent<OnsitePositionDeletedHandler> {
  public static Type<OnsitePositionDeletedHandler> __type__ = new Type<OnsitePositionDeletedHandler>();
  
  public Type<OnsitePositionDeletedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final OnsitePositionDeletedHandler handler) {
    handler.OnsitePositionDeleted(org);
  }
  
  private RCOnsitePositionProxy org;
  
  public OnsitePositionDeletedEvent(final RCOnsitePositionProxy org) {
    this.org=org;
    
  }
}
