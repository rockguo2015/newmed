package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.WorkItemTask4WorkersStatListView;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersStatCriteriaData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = WorkItemTask4WorkersStatListView.class)
public interface WorkItemTask4WorkersStatListPresenterView extends Viewer {
  public abstract void showResult(final Collection<UIWorkItemTask4WorkersStatCriteriaData> results);
}
