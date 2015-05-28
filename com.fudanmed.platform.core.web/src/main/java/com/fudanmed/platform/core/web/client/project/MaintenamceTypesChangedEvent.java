package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.MaintenamceTypesChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class MaintenamceTypesChangedEvent extends GwtEvent<MaintenamceTypesChangedHandler> {
  public static Type<MaintenamceTypesChangedHandler> __type__ = new Type<MaintenamceTypesChangedHandler>();
  
  public Type<MaintenamceTypesChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final MaintenamceTypesChangedHandler handler) {
    handler.MaintenamceTypesChanged();
  }
  
  public MaintenamceTypesChangedEvent() {
    
  }
}
