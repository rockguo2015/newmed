package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.shared.warehouse.AllProductWarehouseStorageSummaryContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorageSummary;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllProductWarehouseStorageSummaryContentProviderServiceAsync {
  public abstract void load(final AllProductWarehouseStorageSummaryContentProviderCriteria criteria, final AsyncCallback<Collection<UIProductWarehouseStorageSummary>> callback);
}
