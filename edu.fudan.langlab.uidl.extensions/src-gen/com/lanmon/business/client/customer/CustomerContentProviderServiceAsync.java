package com.lanmon.business.client.customer;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.lanmon.business.shared.customer.CustomerContentProviderCriteria;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

public interface CustomerContentProviderServiceAsync {
  public abstract void load(final CustomerContentProviderCriteria criteria, final AsyncCallback<Collection<GWTNamedEntity>> callback);
}
