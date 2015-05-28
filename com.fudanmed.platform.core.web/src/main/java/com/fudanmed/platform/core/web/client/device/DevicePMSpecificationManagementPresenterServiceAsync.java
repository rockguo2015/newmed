package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMSpecificationProxy;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;

public interface DevicePMSpecificationManagementPresenterServiceAsync {
  public abstract void filter(final UIDeviceCriteria uicriteria, final AsyncCallback<IPagedResult<UIDevice>> callback);
  
  public abstract void delete(final RCDevicePMSpecificationProxy value, final AsyncCallback<Void> callback);
}
