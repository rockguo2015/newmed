package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverMaterialCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverMaterialCategoryView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverMaterialCategory;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateDeliverMaterialCategoryView.class)
public interface CreateOrUpdateDeliverMaterialCategoryPresenterView extends FormViewer<UIDeliverMaterialCategory> {
  public abstract void setParent(final DLDeliverMaterialCategoryProxy parent);
}
