package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.web.client.deliver.DLTaskManagementView;
import com.fudanmed.platform.core.web.client.deliver.TaskQueryListPresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = DLTaskManagementView.class)
public interface DLTaskManagementPresenterView extends Viewer {
  public abstract void setQueryListPresenter(final TaskQueryListPresenter queryListPresenter);
}
