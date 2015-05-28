package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairTaskStatByOrganizationTypeListView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByOrganizationTypeCriteriaData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = RepairTaskStatByOrganizationTypeListView.class)
public interface RepairTaskStatByOrganizationTypeListPresenterView extends Viewer {
  public abstract void showResult(final Collection<UIRepairTaskStatByOrganizationTypeCriteriaData> results);
}
