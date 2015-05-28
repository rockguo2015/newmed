package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface CreateOrUpdatePMWorkItemPresenterServiceAsync {
  public abstract void loadValue(final RCPMWorkItemProxy pvalue, final AsyncCallback<UIPMWorkItem> callback);
  
  public abstract void updateValue(final UIPMWorkItem uivalue, final AsyncCallback<Void> callback);
  
  public abstract void resolveDevicePMPlans(final Collection<RCDevicePMPlanProxy> selectedPlans, final AsyncCallback<Collection<UIDevicePMPlan>> callback);
  
  public abstract void loadAssignedDevicePlans(final RCPMWorkItemProxy workItem, final AsyncCallback<Collection<UIDevicePMPlan>> callback);
  
  public abstract void createValue(final Collection<RCDevicePMPlanProxy> selectedPlans, final UIPMWorkItem uivalue, final AsyncCallback<Void> callback);
}
