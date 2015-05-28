package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.StockTakingInputQuantityView;
import com.fudanmed.platform.core.web.shared.warehouse.UIStockTakingItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import java.util.Collection;

@ImplementedBy(value = StockTakingInputQuantityView.class)
public interface StockTakingInputQuantityPresenterView extends ViewerWithValidation {
  public abstract Collection<UIStockTakingItem> getItems();
  
  public abstract void setItems(final Collection<UIStockTakingItem> items);
}
