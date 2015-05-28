package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevicePMSpecification;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateDevicePMSpecificationPresenterServiceAsync {
  public abstract void loadValue(final RCDevicePMSpecificationProxy pvalue, final AsyncCallback<UIDevicePMSpecification> callback);
  
  public abstract void updateValue(final UIDevicePMSpecification uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIDevicePMSpecification uivalue, final AsyncCallback<Void> callback);
}
