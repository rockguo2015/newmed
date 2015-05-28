package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStatCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WorkItemStockRecordItemStat4ProductEntryListPresenterServiceAsync {
  public abstract void load(final UIWorkItemStockRecordItemStatCriteria uicriteria, final AsyncCallback<Collection<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData>> callback);
}
