package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.google.gwt.event.shared.EventHandler;

public interface SupplierCreatedHandler extends EventHandler {
  public abstract void SupplierCreated(final RCSupplierProxy supplier);
}
