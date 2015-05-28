package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreatePMWorkItemTeamFinishReportView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemTeamFinishReportData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreatePMWorkItemTeamFinishReportView.class)
public interface CreatePMWorkItemTeamFinishReportPresenterView extends ViewerWithValidation {
  public abstract UIPMWorkItemTeamFinishReportData getValue();
}
