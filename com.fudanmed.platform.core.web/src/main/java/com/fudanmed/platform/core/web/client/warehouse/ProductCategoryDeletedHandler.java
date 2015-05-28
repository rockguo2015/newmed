package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.google.gwt.event.shared.EventHandler;

public interface ProductCategoryDeletedHandler extends EventHandler {
  public abstract void ProductCategoryDeleted(final RCProductCategoryProxy org);
}
