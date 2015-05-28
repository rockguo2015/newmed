package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.CreateOrUpdateProductSpecificationView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateProductSpecificationView.class)
public interface CreateOrUpdateProductSpecificationPresenterView extends ViewerWithValidation {
  public abstract UIProductSpecification getValue();
  
  public abstract void setValue(final UIProductSpecification value);
}
