package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.OrganizationsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class OrganizationsChangedEvent extends GwtEvent<OrganizationsChangedHandler> {
  public static Type<OrganizationsChangedHandler> __type__ = new Type<OrganizationsChangedHandler>();
  
  public Type<OrganizationsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final OrganizationsChangedHandler handler) {
    handler.OrganizationsChanged();
  }
  
  public OrganizationsChangedEvent() {
    
  }
}
