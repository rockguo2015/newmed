package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.GroupTaskMisDispatchReportView;
import com.fudanmed.platform.core.web.shared.project.GroupTaskMisDispatchReportData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = GroupTaskMisDispatchReportView.class)
public interface GroupTaskMisDispatchReportPresenterView extends ViewerWithValidation {
  public abstract GroupTaskMisDispatchReportData getValue();
}
