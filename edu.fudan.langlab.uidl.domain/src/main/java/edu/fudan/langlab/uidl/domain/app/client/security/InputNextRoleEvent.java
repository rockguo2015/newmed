package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import edu.fudan.langlab.uidl.domain.app.client.security.InputNextRoleHandler;

public class InputNextRoleEvent extends GwtEvent<InputNextRoleHandler> {
  public static Type<InputNextRoleHandler> __type__ = new Type<InputNextRoleHandler>();
  
  public Type<InputNextRoleHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InputNextRoleHandler handler) {
    handler.InputNextRole();
  }
  
  public InputNextRoleEvent() {
    
  }
}
