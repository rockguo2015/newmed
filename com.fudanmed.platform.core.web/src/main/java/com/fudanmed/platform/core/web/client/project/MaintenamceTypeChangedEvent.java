package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class MaintenamceTypeChangedEvent extends GwtEvent<MaintenamceTypeChangedHandler> {
  public static Type<MaintenamceTypeChangedHandler> __type__ = new Type<MaintenamceTypeChangedHandler>();
  
  public Type<MaintenamceTypeChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final MaintenamceTypeChangedHandler handler) {
    handler.MaintenamceTypeChanged(org);
  }
  
  private RCMaintenamceTypeProxy org;
  
  public MaintenamceTypeChangedEvent(final RCMaintenamceTypeProxy org) {
    this.org=org;
    
  }
}
