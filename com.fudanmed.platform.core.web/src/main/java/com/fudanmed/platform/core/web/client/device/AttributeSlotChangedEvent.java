package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.AttributeSlotChangedHandler;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class AttributeSlotChangedEvent extends GwtEvent<AttributeSlotChangedHandler> {
  public static Type<AttributeSlotChangedHandler> __type__ = new Type<AttributeSlotChangedHandler>();
  
  public Type<AttributeSlotChangedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final AttributeSlotChangedHandler handler) {
    handler.AttributeSlotChanged(slot);
  }
  
  private UIAttributeSlot slot;
  
  public AttributeSlotChangedEvent(final UIAttributeSlot slot) {
    this.slot=slot;
    
  }
}
