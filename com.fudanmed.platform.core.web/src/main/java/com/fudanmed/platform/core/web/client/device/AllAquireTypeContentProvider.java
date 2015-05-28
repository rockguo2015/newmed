package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy;
import com.fudanmed.platform.core.web.client.device.AllAquireTypeContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllAquireTypeContentProvider extends AbstractAsyncContentProvider<RCAcquireTypeProxy> {
  @Inject
  private AllAquireTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCAcquireTypeProxy>> callback) {
    service.load(callback);
  }
}
