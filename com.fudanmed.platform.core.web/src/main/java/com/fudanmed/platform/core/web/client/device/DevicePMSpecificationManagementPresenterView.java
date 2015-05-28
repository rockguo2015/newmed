package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMSpecificationManagementView;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = DevicePMSpecificationManagementView.class)
public interface DevicePMSpecificationManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIDevice> results);
  
  public abstract void refresh();
  
  public abstract void createRequest(final RequestHandler1<RCDeviceProxy> requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCDevicePMSpecificationProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCDevicePMSpecificationProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIDeviceCriteria> requestHandler);
  
  public abstract void initPM4DeviceRequest(final RequestHandler1<RCDevicePMSpecificationProxy> requestHandler);
  
  public abstract void pmSpecSelected(final RequestHandler1<RCDevicePMSpecificationProxy> requestHandler);
  
  public abstract void deviceSelected(final RequestHandler1<RCDeviceProxy> requestHandler);
  
  public abstract void setOnsiteLocationOutlinePresenter(final OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter);
  
  public abstract void setDeviceCategoryAndTypeListPresenter(final DeviceCategoryAndTypeListPresenter deviceCategoryAndTypeListPresenter);
  
  public abstract void setDevicePMPlanListPresenter(final DevicePMPlanListPresenter devicePMPlanListPresenter);
  
  public abstract void setDevicePMSpecificationListPresenter(final DevicePMSpecificationListPresenter devicePMSpecificationListPresenter);
}
