package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOnsitePositionProxy;
import com.fudanmed.platform.core.web.shared.organization.AllOnsitePositionAyncContentProviderCriteria;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllOnsitePositionAyncContentProviderServiceAsync {
  public abstract void load(final AllOnsitePositionAyncContentProviderCriteria criteria, final AsyncCallback<Collection<RCOnsitePositionProxy>> callback);
}
