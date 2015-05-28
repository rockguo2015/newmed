package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIAttributeSlot;
import com.google.gwt.event.shared.EventHandler;

public interface AttributeSlotChangedHandler extends EventHandler {
  public abstract void AttributeSlotChanged(final UIAttributeSlot slot);
}
