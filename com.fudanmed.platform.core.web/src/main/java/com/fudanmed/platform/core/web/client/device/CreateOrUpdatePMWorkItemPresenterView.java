package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.client.device.CreateOrUpdatePMWorkItemView;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItem;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import java.util.Collection;

@ImplementedBy(value = CreateOrUpdatePMWorkItemView.class)
public interface CreateOrUpdatePMWorkItemPresenterView extends ViewerWithValidation {
  public abstract UIPMWorkItem getValue();
  
  public abstract void setValue(final UIPMWorkItem value);
  
  public abstract void setDevicePlans(final Collection<UIDevicePMPlan> plans);
}
