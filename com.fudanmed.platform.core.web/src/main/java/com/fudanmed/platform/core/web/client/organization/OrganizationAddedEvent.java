package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationAddedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class OrganizationAddedEvent extends GwtEvent<OrganizationAddedHandler> {
  public static Type<OrganizationAddedHandler> __type__ = new Type<OrganizationAddedHandler>();
  
  public Type<OrganizationAddedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final OrganizationAddedHandler handler) {
    handler.OrganizationAdded(org);
  }
  
  private RCOrganizationProxy org;
  
  public OrganizationAddedEvent(final RCOrganizationProxy org) {
    this.org=org;
    
  }
}
