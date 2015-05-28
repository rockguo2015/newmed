package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PartTypeSelectChangedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class PartTypeSelectChangedEvent extends GwtEvent<PartTypeSelectChangedHandler> {
  public static Type<PartTypeSelectChangedHandler> __type__ = new Type<PartTypeSelectChangedHandler>();
  
  public Type<PartTypeSelectChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final PartTypeSelectChangedHandler handler) {
    handler.PartTypeSelectChanged();
  }
  
  public PartTypeSelectChangedEvent() {
    
  }
}
