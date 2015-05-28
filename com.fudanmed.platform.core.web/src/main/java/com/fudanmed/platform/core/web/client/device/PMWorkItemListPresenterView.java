package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.PMWorkItemListView;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = PMWorkItemListView.class)
public interface PMWorkItemListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIPMWorkItem> results);
  
  public abstract ActionContext<UIPMWorkItem> getActionContext();
}
