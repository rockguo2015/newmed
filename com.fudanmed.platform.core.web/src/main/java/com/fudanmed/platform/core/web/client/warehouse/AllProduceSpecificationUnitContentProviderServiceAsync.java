package com.fudanmed.platform.core.web.client.warehouse;

import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface AllProduceSpecificationUnitContentProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<RCProduceSpecificationUnitProxy>> callback);
}
