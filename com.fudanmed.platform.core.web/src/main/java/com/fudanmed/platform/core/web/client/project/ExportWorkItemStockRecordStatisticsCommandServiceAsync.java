package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExportWorkItemStockRecordStatisticsCommandServiceAsync {
  public abstract void prepareExport(final UIWorkItemStockStatisticsCriteria pagedCriteria, final AsyncCallback<String> callback);
}
