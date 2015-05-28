package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.ProductSpecificationUploaderView;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import com.uniquesoft.gwt.shared.datatype.File;

@ImplementedBy(value = ProductSpecificationUploaderView.class)
public interface ProductSpecificationUploaderPresenterView extends ViewerWithValidation {
  public abstract File getFile();
}
