package edu.fudan.langlab.uidl.domain.app.client.security;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import edu.fudan.langlab.uidl.domain.app.client.security.RolesChangedHandler;

public class RolesChangedEvent extends GwtEvent<RolesChangedHandler> {
  public static Type<RolesChangedHandler> __type__ = new Type<RolesChangedHandler>();
  
  public Type<RolesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final RolesChangedHandler handler) {
    handler.RolesChanged();
  }
  
  public RolesChangedEvent() {
    
  }
}
