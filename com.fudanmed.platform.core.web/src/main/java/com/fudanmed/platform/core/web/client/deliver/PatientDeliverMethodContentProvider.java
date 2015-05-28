package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLPatientDeliverMethodProxy;
import com.fudanmed.platform.core.web.client.deliver.PatientDeliverMethodContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class PatientDeliverMethodContentProvider extends AbstractAsyncContentProvider<DLPatientDeliverMethodProxy> {
  @Inject
  private PatientDeliverMethodContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<DLPatientDeliverMethodProxy>> callback) {
    service.load(callback);
  }
}
