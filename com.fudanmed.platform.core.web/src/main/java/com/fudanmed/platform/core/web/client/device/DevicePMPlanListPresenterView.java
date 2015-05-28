package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.DevicePMPlanListView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = DevicePMPlanListView.class)
public interface DevicePMPlanListPresenterView extends Viewer {
  public abstract void setResults(final Collection<UIDevicePMPlan> results);
  
  public abstract ActionContext<UIDevicePMPlan> getActionContext();
}
