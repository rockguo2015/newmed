package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.entityextension.proxy.RCPrimaryTypeProxy;
import com.fudanmed.platform.core.web.client.device.PrimaryTypeContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class PrimaryTypeContentProvider extends AbstractAsyncContentProvider<RCPrimaryTypeProxy> {
  @Inject
  private PrimaryTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCPrimaryTypeProxy>> callback) {
    service.load(callback);
  }
}
