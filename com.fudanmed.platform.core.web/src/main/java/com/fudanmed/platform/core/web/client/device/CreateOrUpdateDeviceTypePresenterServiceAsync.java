package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeCategoryProxy;
import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIDeviceType;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateDeviceTypePresenterServiceAsync {
  public abstract void loadValue(final RCDeviceTypeProxy pvalue, final AsyncCallback<UIDeviceType> callback);
  
  public abstract void updateValue(final UIDeviceType uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValueWithClone(final RCDeviceTypeCategoryProxy categoryType, final RCDeviceTypeProxy cloneSource, final UIDeviceType uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final RCDeviceTypeCategoryProxy categoryType, final UIDeviceType uivalue, final AsyncCallback<Void> callback);
  
  public abstract void loadCategory(final RCDeviceTypeProxy deviceType, final AsyncCallback<RCDeviceTypeCategoryProxy> callback);
}
