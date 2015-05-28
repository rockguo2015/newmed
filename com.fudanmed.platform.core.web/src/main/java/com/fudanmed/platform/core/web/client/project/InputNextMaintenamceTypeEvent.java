package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.client.project.InputNextMaintenamceTypeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InputNextMaintenamceTypeEvent extends GwtEvent<InputNextMaintenamceTypeHandler> {
  public static Type<InputNextMaintenamceTypeHandler> __type__ = new Type<InputNextMaintenamceTypeHandler>();
  
  public Type<InputNextMaintenamceTypeHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InputNextMaintenamceTypeHandler handler) {
    handler.InputNextMaintenamceType(parent);
  }
  
  private RCMaintenamceTypeProxy parent;
  
  public InputNextMaintenamceTypeEvent(final RCMaintenamceTypeProxy parent) {
    this.parent=parent;
    
  }
}
