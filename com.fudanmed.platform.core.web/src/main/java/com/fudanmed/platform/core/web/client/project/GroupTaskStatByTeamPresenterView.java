package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamView;
import com.fudanmed.platform.core.web.client.project.WorkItemStockRecordItemStat4ProductEntryListPresenter;
import com.fudanmed.platform.core.web.client.project.WorkItemTask4WorkersStatListPresenter;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = GroupTaskStatByTeamView.class)
public interface GroupTaskStatByTeamPresenterView extends Viewer {
  public abstract void showResult(final Collection<UIGroupTaskStatByTeamCriteriaData> results);
  
  public abstract void refresh();
  
  public abstract void filterRequest(final RequestHandler1<UIGroupTaskCriteria> requestHandler);
  
  public abstract void setWorkItemTask4WorkersStatListPresenter(final WorkItemTask4WorkersStatListPresenter workItemTask4WorkersStatListPresenter);
  
  public abstract void setWorkItemStockRecordItemStat4ProductEntryListPresenter(final WorkItemStockRecordItemStat4ProductEntryListPresenter workItemStockRecordItemStat4ProductEntryListPresenter);
}
