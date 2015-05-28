package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCAttributeSlotProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface DeviceTypeManagementPresenterServiceAsync {
  public abstract void filter(final UIDeviceTypeCriteria uicriteria, final AsyncCallback<IPagedResult<UIDeviceType>> callback);
  
  public abstract void loadEntityExtension(final RCDeviceTypeProxy value, final AsyncCallback<RCExtensiableEntityProxy> callback);
  
  public abstract void deleteSlotAttribute(final RCAttributeSlotProxy slot, final AsyncCallback<Void> callback);
  
  public abstract void deleteChild(final RCDeviceTypeProxy child, final AsyncCallback<Void> callback);
}
