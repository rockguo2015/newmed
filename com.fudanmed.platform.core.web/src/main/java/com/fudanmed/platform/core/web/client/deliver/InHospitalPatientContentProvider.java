package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalPatientProxy;
import com.fudanmed.platform.core.web.client.deliver.InHospitalPatientContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class InHospitalPatientContentProvider extends AbstractAsyncContentProvider<DLInHospitalPatientProxy> {
  @Inject
  private InHospitalPatientContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<DLInHospitalPatientProxy>> callback) {
    service.load(callback);
  }
}
