package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationManagementView;
import com.fudanmed.platform.core.web.client.deliver.CheckOrganizationQueryListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = CheckOrganizationManagementView.class)
public interface CheckOrganizationManagementPresenterView extends Viewer {
  public abstract void setQueryListPresenter(final CheckOrganizationQueryListPresenter queryListPresenter);
}
