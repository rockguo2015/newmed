package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceTypeCategory;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateDeviceTypeCategoryPresenterServiceAsync {
  public abstract void loadValue(final RCDeviceTypeCategoryProxy pvalue, final AsyncCallback<UIDeviceTypeCategory> callback);
  
  public abstract void updateValue(final UIDeviceTypeCategory uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIDeviceTypeCategory uivalue, final AsyncCallback<RCDeviceTypeCategoryProxy> callback);
}
