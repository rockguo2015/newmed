package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemStockRecordItemStat4ProductEntryListView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordItemStat4ProductEntryCriteriaData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = WorkItemStockRecordItemStat4ProductEntryListView.class)
public interface WorkItemStockRecordItemStat4ProductEntryListPresenterView extends Viewer {
  public abstract void showResult(final Collection<UIWorkItemStockRecordItemStat4ProductEntryCriteriaData> results);
}
