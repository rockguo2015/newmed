package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemStockStatisticListView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockRecordStatisticsData;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStockStatisticsCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = WorkItemStockStatisticListView.class)
public interface WorkItemStockStatisticListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIWorkItemStockRecordStatisticsData> results);
  
  public abstract void refresh();
  
  public abstract void queryRequest(final RequestHandler1<UIWorkItemStockStatisticsCriteria> requestHandler);
}
