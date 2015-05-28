package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.google.gwt.event.shared.EventHandler;

public interface AttributeSlotDeletedHandler extends EventHandler {
  public abstract void AttributeSlotDeleted(final RCAttributeSlotProxy slot);
}
