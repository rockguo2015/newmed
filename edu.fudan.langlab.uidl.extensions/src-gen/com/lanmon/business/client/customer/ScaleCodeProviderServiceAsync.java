package com.lanmon.business.client.customer;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

public interface ScaleCodeProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<GWTNamedEntity>> callback);
}
