package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.client.organization.AllEmployeesContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllEmployeesContentProvider extends AbstractAsyncContentProvider<RCEmployeeProxy> {
  @Inject
  private AllEmployeesContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCEmployeeProxy>> callback) {
    service.load(callback);
  }
}
