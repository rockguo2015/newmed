package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.InputNextOrganizationHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InputNextOrganizationEvent extends GwtEvent<InputNextOrganizationHandler> {
  public static Type<InputNextOrganizationHandler> __type__ = new Type<InputNextOrganizationHandler>();
  
  public Type<InputNextOrganizationHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InputNextOrganizationHandler handler) {
    handler.InputNextOrganization(parent);
  }
  
  private RCOrganizationProxy parent;
  
  public InputNextOrganizationEvent(final RCOrganizationProxy parent) {
    this.parent=parent;
    
  }
}
