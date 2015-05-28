package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class DeliverPatientCheckTypeContentProvider extends AbstractAsyncContentProvider<DLDeliverPatientCheckTypeProxy> {
  @Inject
  private DeliverPatientCheckTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<DLDeliverPatientCheckTypeProxy>> callback) {
    service.load(callback);
  }
}
