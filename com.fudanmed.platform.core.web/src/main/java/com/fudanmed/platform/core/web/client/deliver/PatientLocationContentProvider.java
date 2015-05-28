package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.client.deliver.PatientLocationContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class PatientLocationContentProvider extends AbstractAsyncContentProvider<DLInHospitalLocationProxy> {
  @Inject
  private PatientLocationContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<DLInHospitalLocationProxy>> callback) {
    service.load(callback);
  }
}
