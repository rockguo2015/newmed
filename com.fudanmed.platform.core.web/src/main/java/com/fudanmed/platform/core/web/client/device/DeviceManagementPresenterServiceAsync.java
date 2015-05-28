package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceProxy;
import com.fudanmed.platform.core.entityextension.proxy.RCExtensiableEntityProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface DeviceManagementPresenterServiceAsync {
  public abstract void filter(final UIDeviceCriteria uicriteria, final AsyncCallback<IPagedResult<UIDevice>> callback);
  
  public abstract void delete(final RCDeviceProxy value, final AsyncCallback<Void> callback);
  
  public abstract void loadEntityExtension(final RCDeviceProxy device, final AsyncCallback<RCExtensiableEntityProxy> callback);
}
