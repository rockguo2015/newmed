package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.domain.proxy.RCMaintenanceTeamProxy;
import com.fudanmed.platform.core.web.client.warehouse.CurrentUserStockTeamProviderServiceAsync;
import com.google.inject.Inject;
import com.uniquesoft.gwt.client.common.ServiceCallback;
import com.uniquesoft.gwt.client.common.widgets.contentprovider.AbstractAsyncContentProvider;
import java.util.Collection;

public class CurrentUserStockTeamProvider extends AbstractAsyncContentProvider<RCMaintenanceTeamProxy> {
  @Inject
  private CurrentUserStockTeamProviderServiceAsync service;
  
  protected void doGetContent(final ServiceCallback<Collection<RCMaintenanceTeamProxy>> callback) {
    service.load(callback);
  }
}
