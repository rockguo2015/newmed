package com.uniquesoft.gwt.client.common;

import com.google.gwt.event.shared.GwtEvent;

public class SessionTimeoutEvent extends GwtEvent<SessionTimeoutHandler> {
  public static Type<SessionTimeoutHandler> __type__ = new Type<SessionTimeoutHandler>();
  
  public Type<SessionTimeoutHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final SessionTimeoutHandler handler) {
    handler.SessionTimeout();
  }
  
  public SessionTimeoutEvent() {
    
  }
}
