package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.event.shared.EventHandler;

public interface AttributeSlotAddedHandler extends EventHandler {
  public abstract void AttributeSlotAdded(final UIAttributeSlot slot);
}
