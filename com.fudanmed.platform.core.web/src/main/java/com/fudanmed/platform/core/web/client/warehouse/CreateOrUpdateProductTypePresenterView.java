package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProductCategoryProxy;
import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductTypeView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateProductTypeView.class)
public interface CreateOrUpdateProductTypePresenterView extends ViewerWithValidation {
  public abstract UIProductType getValue();
  
  public abstract void setParent(final RCProductCategoryProxy parent);
  
  public abstract void setValue(final UIProductType value);
}
