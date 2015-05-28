package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductStoreTransaction;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = ProductStoreTransactionListView.class)
public interface ProductStoreTransactionListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIProductStoreTransaction> results);
}
