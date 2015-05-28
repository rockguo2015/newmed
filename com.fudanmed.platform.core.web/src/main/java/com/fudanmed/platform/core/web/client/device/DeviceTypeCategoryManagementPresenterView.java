package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.client.device.DeviceTypeCategoryManagementView;
import com.fudanmed.platform.core.web.client.device.DeviceTypeManagementPresenter;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import java.util.Collection;

@ImplementedBy(value = DeviceTypeCategoryManagementView.class)
public interface DeviceTypeCategoryManagementPresenterView extends Viewer {
  public abstract void showResults(final Collection<UIDeviceTypeCategory> results);
  
  public abstract void updateDeviceTypeCategory(final UIDeviceTypeCategory org);
  
  public abstract void deleteDeviceTypeCategory(final RCDeviceTypeCategoryProxy org);
  
  public abstract void addDeviceTypeCategory(final UIDeviceTypeCategory org);
  
  public abstract void setAsReadonly(final Boolean isReadonly);
  
  public abstract void typeSelected(final RequestHandler1<RCDeviceTypeCategoryProxy> requestHandler);
  
  public abstract void createRequest(final RequestHandler1<RCDeviceTypeCategoryProxy> requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCDeviceTypeCategoryProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCDeviceTypeCategoryProxy> requestHandler);
  
  public abstract ActionContext<UIDeviceTypeCategory> getActionContext();
  
  public abstract void setDeviceTypeManagementPresenter(final DeviceTypeManagementPresenter deviceTypeManagementPresenter);
}
