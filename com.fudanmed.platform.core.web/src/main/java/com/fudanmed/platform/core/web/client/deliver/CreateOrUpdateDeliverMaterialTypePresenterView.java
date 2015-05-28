package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialTypeView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateDeliverMaterialTypeView.class)
public interface CreateOrUpdateDeliverMaterialTypePresenterView extends FormViewer<UIDeliverMaterialType> {
  public abstract void setCategory(final DLDeliverMaterialCategoryProxy category);
}
