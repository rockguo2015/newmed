package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.google.gwt.event.shared.EventHandler;

public interface ProductCategoryAddedHandler extends EventHandler {
  public abstract void ProductCategoryAdded(final RCProductCategoryProxy org);
}
