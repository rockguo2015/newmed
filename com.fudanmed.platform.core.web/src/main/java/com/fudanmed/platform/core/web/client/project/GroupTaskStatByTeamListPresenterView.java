package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.client.project.GroupTaskStatByTeamListPresenterListView;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = GroupTaskStatByTeamListPresenterListView.class)
public interface GroupTaskStatByTeamListPresenterView extends Viewer {
  public abstract void showResult(final Collection<UIGroupTaskStatByTeamCriteriaData> results);
}
