package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStatCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExportWorkItemStockRecordItemStat4ProductEntryCriteriaDataCommandServiceAsync {
  public abstract void prepareExport(final UIWorkItemStockRecordItemStatCriteria uicriteria, final AsyncCallback<String> callback);
}
