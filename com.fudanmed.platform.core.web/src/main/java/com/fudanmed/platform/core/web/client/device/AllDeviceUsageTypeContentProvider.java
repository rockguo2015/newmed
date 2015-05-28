package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy;
import com.fudanmed.platform.core.web.client.device.AllDeviceUsageTypeContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllDeviceUsageTypeContentProvider extends AbstractAsyncContentProvider<RCDeviceUsageTypeProxy> {
  @Inject
  private AllDeviceUsageTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCDeviceUsageTypeProxy>> callback) {
    service.load(callback);
  }
}
