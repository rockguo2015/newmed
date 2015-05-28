package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCFaultReportSourceProxy;
import com.fudanmed.platform.core.web.client.project.FaultReportSourceContentProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class FaultReportSourceContentProvider extends AbstractAsyncContentProvider<RCFaultReportSourceProxy> {
  @Inject
  private FaultReportSourceContentProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCFaultReportSourceProxy>> callback) {
    service.load(callback);
  }
}
