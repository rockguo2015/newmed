package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllDeliverOrganizationContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllDeliverOrganizationContentProvider extends AbstractAsyncContentProvider<DLDeliverOrganizationProxy> {
  @Inject
  private AllDeliverOrganizationContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<DLDeliverOrganizationProxy>> callback) {
    service.load(callback);
  }
}
