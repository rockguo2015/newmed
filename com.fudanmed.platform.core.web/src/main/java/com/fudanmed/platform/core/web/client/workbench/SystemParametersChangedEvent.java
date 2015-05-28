package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.client.workbench.SystemParametersChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class SystemParametersChangedEvent extends GwtEvent<SystemParametersChangedHandler> {
  public static Type<SystemParametersChangedHandler> __type__ = new Type<SystemParametersChangedHandler>();
  
  public Type<SystemParametersChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final SystemParametersChangedHandler handler) {
    handler.SystemParametersChanged();
  }
  
  public SystemParametersChangedEvent() {
    
  }
}
