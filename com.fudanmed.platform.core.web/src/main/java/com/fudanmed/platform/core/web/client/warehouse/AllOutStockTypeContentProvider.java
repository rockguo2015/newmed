package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllOutStockTypeContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllOutStockTypeContentProvider extends AbstractAsyncContentProvider<RCOutStockTypeProxy> {
  @Inject
  private AllOutStockTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCOutStockTypeProxy>> callback) {
    service.load(callback);
  }
}
