package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.client.organization.InputNextOnsitePositionHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class InputNextOnsitePositionEvent extends GwtEvent<InputNextOnsitePositionHandler> {
  public static Type<InputNextOnsitePositionHandler> __type__ = new Type<InputNextOnsitePositionHandler>();
  
  public Type<InputNextOnsitePositionHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final InputNextOnsitePositionHandler handler) {
    handler.InputNextOnsitePosition(parent);
  }
  
  private RCOnsitePositionProxy parent;
  
  public InputNextOnsitePositionEvent(final RCOnsitePositionProxy parent) {
    this.parent=parent;
    
  }
}
