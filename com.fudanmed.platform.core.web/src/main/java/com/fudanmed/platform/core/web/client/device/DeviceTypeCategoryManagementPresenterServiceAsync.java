package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DeviceTypeCategoryManagementPresenterServiceAsync {
  public abstract void loadAllDeviceTypeCategory(final AsyncCallback<Collection<UIDeviceTypeCategory>> callback);
  
  public abstract void delete(final RCDeviceTypeCategoryProxy value, final AsyncCallback<Void> callback);
  
  public abstract void getValue(final RCDeviceTypeCategoryProxy org, final AsyncCallback<UIDeviceTypeCategory> callback);
  
  public abstract void loadItems(final RCDeviceTypeCategoryProxy value, final AsyncCallback<Collection<UIDeviceType>> callback);
  
  public abstract void deleteChild(final RCDeviceTypeProxy child, final AsyncCallback<Void> callback);
}
