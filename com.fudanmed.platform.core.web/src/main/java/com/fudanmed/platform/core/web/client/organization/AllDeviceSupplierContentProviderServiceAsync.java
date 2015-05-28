package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import com.fudanmed.platform.core.web.shared.organization.AllDeviceSupplierContentProviderCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllDeviceSupplierContentProviderServiceAsync {
  public abstract void load(final AllDeviceSupplierContentProviderCriteria criteria, final AsyncCallback<Collection<RCSupplierProxy>> callback);
}
