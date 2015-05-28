package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelProxy;
import com.fudanmed.platform.core.web.client.organization.AllFaultLevelContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllFaultLevelContentProvider extends AbstractAsyncContentProvider<RCFaultLevelProxy> {
  @Inject
  private AllFaultLevelContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCFaultLevelProxy>> callback) {
    service.load(callback);
  }
}
