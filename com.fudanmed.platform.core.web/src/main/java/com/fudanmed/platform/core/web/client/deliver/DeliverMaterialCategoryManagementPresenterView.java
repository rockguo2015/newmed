package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialCategoryManagementView;
import com.fudanmed.platform.core.web.client.deliver.DeliverMaterialTypeQueryListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = DeliverMaterialCategoryManagementView.class)
public interface DeliverMaterialCategoryManagementPresenterView extends Viewer {
  public abstract void setQueryListPresenter(final DeliverMaterialCategoryListPresenter queryListPresenter);
  
  public abstract void setDeliverMaterialTypeQueryListPresenter(final DeliverMaterialTypeQueryListPresenter deliverMaterialTypeQueryListPresenter);
}
