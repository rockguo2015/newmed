package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultEmergencyLevelProxy;
import com.fudanmed.platform.core.web.client.organization.AllFaultEmergencyLevelContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllFaultEmergencyLevelContentProvider extends AbstractAsyncContentProvider<RCFaultEmergencyLevelProxy> {
  @Inject
  private AllFaultEmergencyLevelContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCFaultEmergencyLevelProxy>> callback) {
    service.load(callback);
  }
}
