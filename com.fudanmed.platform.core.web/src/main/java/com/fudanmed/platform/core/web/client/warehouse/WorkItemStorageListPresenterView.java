package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.web.client.warehouse.WorkItemStorageListView;
import com.fudanmed.platform.core.web.shared.warehouse.UIWorkItemStorage;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import java.util.Collection;

@ImplementedBy(value = WorkItemStorageListView.class)
public interface WorkItemStorageListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIWorkItemStorage> results);
}
