package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import edu.fudan.langlab.uidl.domain.app.client.security.AppFunctionAssignmentsChangedHandler;
import edu.fudan.langlab.uidl.domain.app.shared.security.UIAppRole;

public class AppFunctionAssignmentsChangedEvent extends GwtEvent<AppFunctionAssignmentsChangedHandler> {
  public static Type<AppFunctionAssignmentsChangedHandler> __type__ = new Type<AppFunctionAssignmentsChangedHandler>();
  
  public Type<AppFunctionAssignmentsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final AppFunctionAssignmentsChangedHandler handler) {
    handler.AppFunctionAssignmentsChanged(role);
  }
  
  private UIAppRole role;
  
  public AppFunctionAssignmentsChangedEvent(final UIAppRole role) {
    this.role=role;
    
  }
}
