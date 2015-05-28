package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.SettlementsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SettlementsChangedEvent extends GwtEvent<SettlementsChangedHandler> {
  public static Type<SettlementsChangedHandler> __type__ = new Type<SettlementsChangedHandler>();
  
  public Type<SettlementsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final SettlementsChangedHandler handler) {
    handler.SettlementsChanged();
  }
  
  public SettlementsChangedEvent() {
    
  }
}
