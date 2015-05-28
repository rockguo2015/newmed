package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotDeletedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class AttributeSlotDeletedEvent extends GwtEvent<AttributeSlotDeletedHandler> {
  public static Type<AttributeSlotDeletedHandler> __type__ = new Type<AttributeSlotDeletedHandler>();
  
  public Type<AttributeSlotDeletedHandler> getAssociatedType() {
    return __type__;
  }
  
  public void dispatch(final AttributeSlotDeletedHandler handler) {
    handler.AttributeSlotDeleted(slot);
  }
  
  private RCAttributeSlotProxy slot;
  
  public AttributeSlotDeletedEvent(final RCAttributeSlotProxy slot) {
    this.slot=slot;
    
  }
}
