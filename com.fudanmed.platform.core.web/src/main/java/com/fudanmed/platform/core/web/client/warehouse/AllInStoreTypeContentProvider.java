package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllInStoreTypeContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllInStoreTypeContentProvider extends AbstractAsyncContentProvider<RCInStoreTypeProxy> {
  @Inject
  private AllInStoreTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCInStoreTypeProxy>> callback) {
    service.load(callback);
  }
}
