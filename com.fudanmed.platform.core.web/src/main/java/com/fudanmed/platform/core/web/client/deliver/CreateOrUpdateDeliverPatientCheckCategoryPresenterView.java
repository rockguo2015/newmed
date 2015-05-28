package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckCategoryView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateDeliverPatientCheckCategoryView.class)
public interface CreateOrUpdateDeliverPatientCheckCategoryPresenterView extends FormViewer<UIDeliverPatientCheckCategory> {
  public abstract void setParent(final DLDeliverPatientCheckCategoryProxy parent);
}
