package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.client.warehouse.AllWorkItemTaskContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllWorkItemTaskContentProvider extends AbstractAsyncContentProvider<RCWorkItemTaskProxy> {
  @Inject
  private AllWorkItemTaskContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCWorkItemTaskProxy>> callback) {
    service.load(callback);
  }
}
