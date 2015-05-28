package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIRepairTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIRepairTaskStatByMonthCriteriaData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface RepairTaskStatByMonthPresenterServiceAsync {
  public abstract void loadResult(final UIRepairTaskCriteria uicriteria, final AsyncCallback<Collection<UIRepairTaskStatByMonthCriteriaData>> callback);
}
