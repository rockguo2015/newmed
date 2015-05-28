package edu.fudan.langlab.uidl.domain.app.client.login;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import edu.fudan.langlab.uidl.domain.app.client.login.LogoutHandler;

public class LogoutEvent extends GwtEvent<LogoutHandler> {
  public static Type<LogoutHandler> __type__ = new Type<LogoutHandler>();
  
  public Type<LogoutHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final LogoutHandler handler) {
    handler.Logout();
  }
  
  public LogoutEvent() {
    
  }
}
