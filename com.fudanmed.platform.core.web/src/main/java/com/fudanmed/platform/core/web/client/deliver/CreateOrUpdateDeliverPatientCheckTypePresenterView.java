package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.client.deliver.CreateOrUpdateDeliverPatientCheckTypeView;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.FormViewer;

@ImplementedBy(value = CreateOrUpdateDeliverPatientCheckTypeView.class)
public interface CreateOrUpdateDeliverPatientCheckTypePresenterView extends FormViewer<UIDeliverPatientCheckType> {
  public abstract void setCategory(final DLDeliverPatientCheckCategoryProxy category);
}
