package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByReportSourceCriteriaData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface RepairTaskStatByReportSourcePresenterServiceAsync {
  public abstract void loadResult(final UIRepairTaskCriteria uicriteria, final AsyncCallback<Collection<UIRepairTaskStatByReportSourceCriteriaData>> callback);
}
