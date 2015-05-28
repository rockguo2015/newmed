package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateWarehouseView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWarehouse;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateWarehouseView.class)
public interface CreateOrUpdateWarehousePresenterView extends ViewerWithValidation {
  public abstract UIWarehouse getValue();
  
  public abstract void setValue(final UIWarehouse value);
}
