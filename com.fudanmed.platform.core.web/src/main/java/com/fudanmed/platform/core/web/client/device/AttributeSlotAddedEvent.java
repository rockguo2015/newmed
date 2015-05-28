package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.AttributeSlotAddedHandler;
import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class AttributeSlotAddedEvent extends GwtEvent<AttributeSlotAddedHandler> {
  public static Type<AttributeSlotAddedHandler> __type__ = new Type<AttributeSlotAddedHandler>();
  
  public Type<AttributeSlotAddedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final AttributeSlotAddedHandler handler) {
    handler.AttributeSlotAdded(slot);
  }
  
  private UIAttributeSlot slot;
  
  public AttributeSlotAddedEvent(final UIAttributeSlot slot) {
    this.slot=slot;
    
  }
}
