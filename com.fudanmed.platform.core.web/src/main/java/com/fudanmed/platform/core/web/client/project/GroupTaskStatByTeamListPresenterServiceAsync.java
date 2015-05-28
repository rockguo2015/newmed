package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIGroupTaskCriteria;
import com.fudanmed.platform.core.web.shared.project.UIGroupTaskStatByTeamCriteriaData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface GroupTaskStatByTeamListPresenterServiceAsync {
  public abstract void loadResult(final UIGroupTaskCriteria uicriteria, final AsyncCallback<Collection<UIGroupTaskStatByTeamCriteriaData>> callback);
}
