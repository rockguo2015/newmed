package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductStoreTransactionListPresenter;
import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotManagementView;
import com.fudanmed.platform.core.web.client.warehouse.ProductSummarySnapshotQueryListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = ProductSummarySnapshotManagementView.class)
public interface ProductSummarySnapshotManagementPresenterView extends Viewer {
  public abstract void setQueryListPresenter(final ProductSummarySnapshotQueryListPresenter queryListPresenter);
  
  public abstract void setProductStoreTransactionListPresenter(final ProductStoreTransactionListPresenter productStoreTransactionListPresenter);
}
