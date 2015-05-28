package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

public interface DevicePMPlanSelectorPresenterServiceAsync {
  public abstract void filter(final UIDevicePMPlanCriteria uicriteria, final AsyncCallback<IPagedResult<UIDevicePMPlan>> callback);
  
  public abstract void assignPlansToWorkItem(final RCPMWorkItemProxy workItem, final Collection<RCDevicePMPlanProxy> selectedPlans, final AsyncCallback<Void> callback);
}
