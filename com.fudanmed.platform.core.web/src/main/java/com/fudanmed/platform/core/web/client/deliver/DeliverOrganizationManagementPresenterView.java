package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationManagementView;
import com.fudanmed.platform.core.web.client.deliver.DeliverOrganizationQueryListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = DeliverOrganizationManagementView.class)
public interface DeliverOrganizationManagementPresenterView extends Viewer {
  public abstract void setQueryListPresenter(final DeliverOrganizationQueryListPresenter queryListPresenter);
}
