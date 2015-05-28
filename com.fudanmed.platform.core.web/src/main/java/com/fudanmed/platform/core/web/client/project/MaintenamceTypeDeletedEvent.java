package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.MaintenamceTypeDeletedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class MaintenamceTypeDeletedEvent extends GwtEvent<MaintenamceTypeDeletedHandler> {
  public static Type<MaintenamceTypeDeletedHandler> __type__ = new Type<MaintenamceTypeDeletedHandler>();
  
  public Type<MaintenamceTypeDeletedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final MaintenamceTypeDeletedHandler handler) {
    handler.MaintenamceTypeDeleted(org);
  }
  
  private RCMaintenamceTypeProxy org;
  
  public MaintenamceTypeDeletedEvent(final RCMaintenamceTypeProxy org) {
    this.org=org;
    
  }
}
