package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairTaskStatByFaultTypeListView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByFaultTypeCriteriaData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = RepairTaskStatByFaultTypeListView.class)
public interface RepairTaskStatByFaultTypeListPresenterView extends Viewer {
  public abstract void showResult(final Collection<UIRepairTaskStatByFaultTypeCriteriaData> results);
}
