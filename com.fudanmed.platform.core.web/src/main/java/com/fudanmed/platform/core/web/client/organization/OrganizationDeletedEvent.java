package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationDeletedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class OrganizationDeletedEvent extends GwtEvent<OrganizationDeletedHandler> {
  public static Type<OrganizationDeletedHandler> __type__ = new Type<OrganizationDeletedHandler>();
  
  public Type<OrganizationDeletedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final OrganizationDeletedHandler handler) {
    handler.OrganizationDeleted(org);
  }
  
  private RCOrganizationProxy org;
  
  public OrganizationDeletedEvent(final RCOrganizationProxy org) {
    this.org=org;
    
  }
}
