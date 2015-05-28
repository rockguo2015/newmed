package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.google.gwt.event.shared.EventHandler;

public interface OnsitePositionDeletedHandler extends EventHandler {
  public abstract void OnsitePositionDeleted(final RCOnsitePositionProxy org);
}
