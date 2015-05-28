package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCWarehouseProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWarehouseContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllWarehouseContentProvider extends AbstractAsyncContentProvider<RCWarehouseProxy> {
  @Inject
  private AllWarehouseContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCWarehouseProxy>> callback) {
    service.load(callback);
  }
}
