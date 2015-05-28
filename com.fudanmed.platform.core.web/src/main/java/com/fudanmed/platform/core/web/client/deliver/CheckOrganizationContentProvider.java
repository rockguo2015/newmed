package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class CheckOrganizationContentProvider extends AbstractAsyncContentProvider<DLCheckOrganizationProxy> {
  @Inject
  private CheckOrganizationContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<DLCheckOrganizationProxy>> callback) {
    service.load(callback);
  }
}
