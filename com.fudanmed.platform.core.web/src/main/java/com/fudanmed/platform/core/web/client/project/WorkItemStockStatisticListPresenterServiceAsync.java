package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WorkItemStockStatisticListPresenterServiceAsync {
  public abstract void loadRepairTaskList(final UIWorkItemStockStatisticsCriteria uicriteria, final AsyncCallback<Collection<UIWorkItemStockRecordStatisticsData>> callback);
}
