package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy;
import com.fudanmed.platform.core.web.client.device.AllDeviceIndicatorContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllDeviceIndicatorContentProvider extends AbstractAsyncContentProvider<RCDeviceIndicatorProxy> {
  @Inject
  private AllDeviceIndicatorContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCDeviceIndicatorProxy>> callback) {
    service.load(callback);
  }
}
