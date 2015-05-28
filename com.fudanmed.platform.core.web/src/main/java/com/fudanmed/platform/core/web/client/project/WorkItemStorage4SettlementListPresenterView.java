package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemStorage4SettlementListView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = WorkItemStorage4SettlementListView.class)
public interface WorkItemStorage4SettlementListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIWorkItemStorage4Settlement> results);
  
  public abstract void materialExportRequest(final RequestHandler requestHandler);
}
