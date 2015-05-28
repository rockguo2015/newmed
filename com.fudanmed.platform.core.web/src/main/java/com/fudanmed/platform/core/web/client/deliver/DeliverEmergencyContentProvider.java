package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverEmergencyProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverEmergencyContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class DeliverEmergencyContentProvider extends AbstractAsyncContentProvider<DLDeliverEmergencyProxy> {
  @Inject
  private DeliverEmergencyContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<DLDeliverEmergencyProxy>> callback) {
    service.load(callback);
  }
}
