package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.client.organization.EmployeesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class EmployeesChangedEvent extends GwtEvent<EmployeesChangedHandler> {
  public static Type<EmployeesChangedHandler> __type__ = new Type<EmployeesChangedHandler>();
  
  public Type<EmployeesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final EmployeesChangedHandler handler) {
    handler.EmployeesChanged();
  }
  
  public EmployeesChangedEvent() {
    
  }
}
