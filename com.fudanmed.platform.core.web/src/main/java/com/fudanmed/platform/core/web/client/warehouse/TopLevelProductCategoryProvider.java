package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.client.warehouse.TopLevelProductCategoryProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class TopLevelProductCategoryProvider extends AbstractAsyncContentProvider<RCProductCategoryProxy> {
  @Inject
  private TopLevelProductCategoryProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCProductCategoryProxy>> callback) {
    service.load(callback);
  }
}
