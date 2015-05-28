package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckCategoryListPresenter;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeManagementView;
import com.fudanmed.platform.core.web.client.deliver.DeliverPatientCheckTypeQueryListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = DeliverPatientCheckTypeManagementView.class)
public interface DeliverPatientCheckTypeManagementPresenterView extends Viewer {
  public abstract void setCategoryQueryListPresenter(final DeliverPatientCheckCategoryListPresenter categoryQueryListPresenter);
  
  public abstract void setDeliverPatientCheckTypeQueryListPresenter(final DeliverPatientCheckTypeQueryListPresenter deliverPatientCheckTypeQueryListPresenter);
}
