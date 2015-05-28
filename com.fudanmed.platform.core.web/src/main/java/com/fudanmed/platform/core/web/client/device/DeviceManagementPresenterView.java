package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceCategoryAndTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceManagementView;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanAssignmentListPresenter;
import com.fudanmed.platform.core.web.client.device.DevicePMPlanList4DevicePresenter;
import com.fudanmed.platform.core.web.client.device.DevicePropertyPresenter;
import com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenter;
import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.client.organization.OnsiteLocationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.fudanmed.platform.core.web.shared.organization.UIOnsitePosition;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.command.IContextProvider;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = DeviceManagementView.class)
public interface DeviceManagementPresenterView extends Viewer, IContextProvider<RCDeviceProxy> {
  public abstract void showResults(final IPagedResult<UIDevice> results);
  
  public abstract void refresh();
  
  public abstract void createRequest(final RequestHandler requestHandler);
  
  public abstract void duplicateRequest(final RequestHandler1<RCDeviceProxy> requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCDeviceProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCDeviceProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIDeviceCriteria> requestHandler);
  
  public abstract void deviceSelected(final RequestHandler1<RCDeviceProxy> requestHandler);
  
  public abstract void showPMEvaluateInfo(final RequestHandler1<RCPMWorkItemProxy> requestHandler);
  
  public abstract void showPMWorkItemInfo(final RequestHandler1<RCPMWorkItemProxy> requestHandler);
  
  public abstract RCDeviceTypeProxy getSelectedDeviceType();
  
  public abstract UIOnsitePosition getSelectedLocation();
  
  public abstract ActionContext<RCDeviceProxy> getActionContext();
  
  public abstract void setAttributeSlotTreeListPresenter(final AttributeSlotTreeListPresenter attributeSlotTreeListPresenter);
  
  public abstract void setDevicePropertyPresenter(final DevicePropertyPresenter devicePropertyPresenter);
  
  public abstract void setDevicePMPlanList4DevicePresenter(final DevicePMPlanList4DevicePresenter devicePMPlanList4DevicePresenter);
  
  public abstract void setDeviceDocumentStorageListPresenter(final DocumentStorageListPresenter deviceDocumentStorageListPresenter);
  
  public abstract void setDevicepictureListPresenter(final PictureListPresenter devicepictureListPresenter);
  
  public abstract void setOnsiteLocationOutlinePresenter(final OnsiteLocationOutlinePresenter onsiteLocationOutlinePresenter);
  
  public abstract void setDeviceCategoryAndTypeListPresenter(final DeviceCategoryAndTypeListPresenter deviceCategoryAndTypeListPresenter);
  
  public abstract void setDevicePMPlanAssignmentListPresenter(final DevicePMPlanAssignmentListPresenter devicePMPlanAssignmentListPresenter);
}
