package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeAddedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class MaintenamceTypeAddedEvent extends GwtEvent<MaintenamceTypeAddedHandler> {
  public static Type<MaintenamceTypeAddedHandler> __type__ = new Type<MaintenamceTypeAddedHandler>();
  
  public Type<MaintenamceTypeAddedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final MaintenamceTypeAddedHandler handler) {
    handler.MaintenamceTypeAdded(org);
  }
  
  private RCMaintenamceTypeProxy org;
  
  public MaintenamceTypeAddedEvent(final RCMaintenamceTypeProxy org) {
    this.org=org;
    
  }
}
