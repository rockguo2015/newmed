package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.AllDeviceContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllDeviceContentProviderServiceAsync {
  public abstract void load(final AllDeviceContentProviderCriteria criteria, final AsyncCallback<Collection<UIDevice>> callback);
}
