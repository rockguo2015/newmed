package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.web.client.device.AttributeSlotTreeListPresenter;
import com.fudanmed.platform.core.web.client.device.DeviceTypeManagementView;
import com.fudanmed.platform.core.web.client.device.DocumentStorageListPresenter;
import com.fudanmed.platform.core.web.client.device.PMDefaultIntervalAssociationListPresenter;
import com.fudanmed.platform.core.web.client.device.PartTypeListPresenter;
import com.fudanmed.platform.core.web.client.device.PictureListPresenter;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCriteria;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.client.common.action.ActionContext;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

@ImplementedBy(value = DeviceTypeManagementView.class)
public interface DeviceTypeManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIDeviceType> results);
  
  public abstract void refresh();
  
  public abstract void createChildRequest(final RequestHandler1<RCDeviceTypeCategoryProxy> requestHandler);
  
  public abstract void cloneChildRequest(final RequestHandler1<RCDeviceTypeProxy> requestHandler);
  
  public abstract void modifyChildRequest(final RequestHandler1<RCDeviceTypeProxy> requestHandler);
  
  public abstract void deleteChildRequest(final RequestHandler1<RCDeviceTypeProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIDeviceTypeCriteria> requestHandler);
  
  public abstract void newParameterRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler);
  
  public abstract void newCategoryRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler);
  
  public abstract void deleteAttributeRequest(final RequestHandler1<RCAttributeSlotProxy> requestHandler);
  
  public abstract void showAttributeSlotEditorRequest(final RequestHandler1<RCDeviceTypeProxy> requestHandler);
  
  public abstract void deviceTypeSelected(final RequestHandler1<RCDeviceTypeProxy> requestHandler);
  
  public abstract RCDeviceTypeProxy getSelectedDeviceType();
  
  public abstract ActionContext<UIDeviceType> getActionContext();
  
  public abstract void setTypeCategoryActionContext(final ActionContext<UIDeviceTypeCategory> ac);
  
  public abstract void filterByCategory(final RCDeviceTypeCategoryProxy category);
  
  public abstract void setPartTypeListPresenter(final PartTypeListPresenter partTypeListPresenter);
  
  public abstract void setAttributeSlotTreeListPresenter(final AttributeSlotTreeListPresenter attributeSlotTreeListPresenter);
  
  public abstract void setDefaultIntervalAssociationListPresenter(final PMDefaultIntervalAssociationListPresenter defaultIntervalAssociationListPresenter);
  
  public abstract void setDeviceDocumentStorageListPresenter(final DocumentStorageListPresenter deviceDocumentStorageListPresenter);
  
  public abstract void setDevicepictureListPresenter(final PictureListPresenter devicepictureListPresenter);
}
