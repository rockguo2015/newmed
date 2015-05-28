package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.InputNextEmployeeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InputNextEmployeeEvent extends GwtEvent<InputNextEmployeeHandler> {
  public static Type<InputNextEmployeeHandler> __type__ = new Type<InputNextEmployeeHandler>();
  
  public Type<InputNextEmployeeHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InputNextEmployeeHandler handler) {
    handler.InputNextEmployee(parent);
  }
  
  private RCOrganizationProxy parent;
  
  public InputNextEmployeeEvent(final RCOrganizationProxy parent) {
    this.parent=parent;
    
  }
}
