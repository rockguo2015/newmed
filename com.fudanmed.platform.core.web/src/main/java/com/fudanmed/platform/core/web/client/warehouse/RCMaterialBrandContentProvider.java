package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import com.fudanmed.platform.core.web.client.warehouse.RCMaterialBrandContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class RCMaterialBrandContentProvider extends AbstractAsyncContentProvider<RCMaterialBrandProxy> {
  @Inject
  private RCMaterialBrandContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCMaterialBrandProxy>> callback) {
    service.load(callback);
  }
}
