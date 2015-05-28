package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.proxy.RCDeviceTypeProxy;
import com.fudanmed.platform.core.warehouse.proxy.RCProductSpecificationProxy;
import com.fudanmed.platform.core.web.shared.warehouse.UIProductSpecification;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface PartTypeListPresenterServiceAsync {
  public abstract void loadProductSpecificationList(final RCDeviceTypeProxy context, final AsyncCallback<Collection<UIProductSpecification>> callback);
  
  public abstract void delete(final RCDeviceTypeProxy context, final RCProductSpecificationProxy value, final AsyncCallback<Void> callback);
}
