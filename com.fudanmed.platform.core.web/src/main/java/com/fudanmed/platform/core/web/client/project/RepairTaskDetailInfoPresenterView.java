package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairTaskDetailInfoView;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = RepairTaskDetailInfoView.class)
public interface RepairTaskDetailInfoPresenterView extends Viewer {
  public abstract void setValue(final UIRepairTask repairTask);
}
