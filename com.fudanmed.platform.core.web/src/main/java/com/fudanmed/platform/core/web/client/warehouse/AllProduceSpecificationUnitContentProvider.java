package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllProduceSpecificationUnitContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllProduceSpecificationUnitContentProvider extends AbstractAsyncContentProvider<RCProduceSpecificationUnitProxy> {
  @Inject
  private AllProduceSpecificationUnitContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCProduceSpecificationUnitProxy>> callback) {
    service.load(callback);
  }
}
