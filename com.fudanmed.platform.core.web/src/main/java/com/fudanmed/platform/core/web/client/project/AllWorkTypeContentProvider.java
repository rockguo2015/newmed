package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy;
import com.fudanmed.platform.core.web.client.project.AllWorkTypeContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class AllWorkTypeContentProvider extends AbstractAsyncContentProvider<RCWorkTypeProxy> {
  @Inject
  private AllWorkTypeContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCWorkTypeProxy>> callback) {
    service.load(callback);
  }
}
