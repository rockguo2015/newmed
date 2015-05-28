package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductWarehouseStorageListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductWarehouseStorage;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = ProductWarehouseStorageListView.class)
public interface ProductWarehouseStorageListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIProductWarehouseStorage> results);
}
