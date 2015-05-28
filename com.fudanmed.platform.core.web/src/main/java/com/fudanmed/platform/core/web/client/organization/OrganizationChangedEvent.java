package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class OrganizationChangedEvent extends GwtEvent<OrganizationChangedHandler> {
  public static Type<OrganizationChangedHandler> __type__ = new Type<OrganizationChangedHandler>();
  
  public Type<OrganizationChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final OrganizationChangedHandler handler) {
    handler.OrganizationChanged(org);
  }
  
  private RCOrganizationProxy org;
  
  public OrganizationChangedEvent(final RCOrganizationProxy org) {
    this.org=org;
    
  }
}
