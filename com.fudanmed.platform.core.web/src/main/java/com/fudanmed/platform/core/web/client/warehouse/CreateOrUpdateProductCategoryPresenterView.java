package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductCategoryView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductCategory;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateProductCategoryView.class)
public interface CreateOrUpdateProductCategoryPresenterView extends ViewerWithValidation {
  public abstract UIProductCategory getValue();
  
  public abstract void setParent(final RCProductCategoryProxy parent);
  
  public abstract void setValue(final UIProductCategory value);
}
