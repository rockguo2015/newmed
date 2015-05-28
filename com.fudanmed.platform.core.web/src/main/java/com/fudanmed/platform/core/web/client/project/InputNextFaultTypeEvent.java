package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.InputNextFaultTypeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InputNextFaultTypeEvent extends GwtEvent<InputNextFaultTypeHandler> {
  public static Type<InputNextFaultTypeHandler> __type__ = new Type<InputNextFaultTypeHandler>();
  
  public Type<InputNextFaultTypeHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InputNextFaultTypeHandler handler) {
    handler.InputNextFaultType(parent);
  }
  
  private RCMaintenamceTypeProxy parent;
  
  public InputNextFaultTypeEvent(final RCMaintenamceTypeProxy parent) {
    this.parent=parent;
    
  }
}
