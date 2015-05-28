package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationDetailView;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = ProductSpecificationDetailView.class)
public interface ProductSpecificationDetailPresenterView extends Viewer {
  public abstract void showDetail(final UIProductSpecification detail);
}
