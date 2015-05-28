package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.GroupTaskFinishReportView;
import com.fudanmed.platform.core.web.shared.project.GroupTaskFinishReportData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = GroupTaskFinishReportView.class)
public interface GroupTaskFinishReportPresenterView extends ViewerWithValidation {
  public abstract GroupTaskFinishReportData getValue();
}
