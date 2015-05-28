package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMPlanProxy;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanSelectorView;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlan;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMPlanCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

@ImplementedBy(value = DevicePMPlanSelectorView.class)
public interface DevicePMPlanSelectorPresenterView extends ViewerWithValidation {
  public abstract void showResults(final IPagedResult<UIDevicePMPlan> results);
  
  public abstract void refresh();
  
  public abstract void setUsage(final Boolean forSelector);
  
  public abstract Collection<RCDevicePMPlanProxy> getSelectedValues();
  
  public abstract void filterRequest(final RequestHandler1<UIDevicePMPlanCriteria> requestHandler);
  
  public abstract void setOnsiteLocationOutlinePresenter(final OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter);
  
  public abstract void setDeviceCategoryAndTypeListPresenter(final DeviceCategoryAndTypeListPresenter deviceCategoryAndTypeListPresenter);
}
