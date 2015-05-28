package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.web.shared.device.UIPartTypeSelectData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdatePartTypeSelectDataPresenterServiceAsync {
  public abstract void createValue(final RCDeviceTypeProxy parent, final UIPartTypeSelectData uivalue, final AsyncCallback<Void> callback);
}
