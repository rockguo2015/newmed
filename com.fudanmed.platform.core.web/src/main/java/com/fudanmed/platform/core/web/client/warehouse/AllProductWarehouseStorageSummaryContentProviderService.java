package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageSummaryContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.warehouse.AllProductWarehouseStorageSummaryContentProviderService")
public interface AllProductWarehouseStorageSummaryContentProviderService extends RemoteService {
  public abstract Collection<UIProductWarehouseStorageSummary> load(final AllProductWarehouseStorageSummaryContentProviderCriteria criteria);
}
