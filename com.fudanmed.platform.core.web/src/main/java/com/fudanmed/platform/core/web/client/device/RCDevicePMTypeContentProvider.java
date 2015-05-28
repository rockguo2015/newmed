package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import com.fudanmed.platform.core.web.client.device.RCDevicePMTypeContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class RCDevicePMTypeContentProvider extends AbstractAsyncContentProvider<RCDevicePMTypeProxy> {
  @Inject
  private RCDevicePMTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCDevicePMTypeProxy>> callback) {
    service.load(callback);
  }
}
