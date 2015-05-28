package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.web.client.project.AllFaultTypeContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllFaultTypeContentProvider extends AbstractAsyncContentProvider<RCFaultTypeProxy> {
  @Inject
  private AllFaultTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCFaultTypeProxy>> callback) {
    service.load(callback);
  }
}
