package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.web.shared.device.AllDeviceContentProviderCriteria;
import com.fudanmed.platform.core.web.shared.device.UIDevice;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.device.AllDeviceContentProviderService")
public interface AllDeviceContentProviderService extends RemoteService {
  public abstract Collection<UIDevice> load(final AllDeviceContentProviderCriteria criteria);
}
