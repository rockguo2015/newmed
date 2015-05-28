package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.AllOrganizationContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllOrganizationContentProvider extends AbstractAsyncContentProvider<RCOrganizationProxy> {
  @Inject
  private AllOrganizationContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCOrganizationProxy>> callback) {
    service.load(callback);
  }
}
