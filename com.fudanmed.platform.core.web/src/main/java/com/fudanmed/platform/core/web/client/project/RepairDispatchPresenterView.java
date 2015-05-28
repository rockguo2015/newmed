package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.RepairDispatchView;
import com.fudanmed.platform.core.web.shared.project.UIRepairDispatchData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = RepairDispatchView.class)
public interface RepairDispatchPresenterView extends ViewerWithValidation {
  public abstract UIRepairDispatchData getRepairDispatchData();
}
