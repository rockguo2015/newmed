package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersCriteria;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask4WorkersStatCriteriaData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WorkItemTask4WorkersStatListPresenterServiceAsync {
  public abstract void load(final UIWorkItemTask4WorkersCriteria uicriteria, final AsyncCallback<Collection<UIWorkItemTask4WorkersStatCriteriaData>> callback);
}
