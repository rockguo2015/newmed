package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.AllDeviceTypeContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllDeviceTypeContentProvider extends AbstractAsyncContentProvider<RCDeviceTypeProxy> {
  @Inject
  private AllDeviceTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCDeviceTypeProxy>> callback) {
    service.load(callback);
  }
}
