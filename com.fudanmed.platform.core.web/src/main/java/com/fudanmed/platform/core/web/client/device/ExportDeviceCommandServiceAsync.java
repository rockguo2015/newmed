package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.UIDeviceCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ExportDeviceCommandServiceAsync {
  public abstract void prepareExport(final UIDeviceCriteria pagedCriteria, final AsyncCallback<String> callback);
}
