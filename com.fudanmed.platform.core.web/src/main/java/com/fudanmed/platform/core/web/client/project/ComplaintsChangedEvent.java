package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.ComplaintsChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ComplaintsChangedEvent extends GwtEvent<ComplaintsChangedHandler> {
  public static Type<ComplaintsChangedHandler> __type__ = new Type<ComplaintsChangedHandler>();
  
  public Type<ComplaintsChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final ComplaintsChangedHandler handler) {
    handler.ComplaintsChanged();
  }
  
  public ComplaintsChangedEvent() {
    
  }
}
