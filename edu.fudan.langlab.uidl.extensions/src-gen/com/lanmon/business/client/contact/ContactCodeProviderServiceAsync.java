package com.lanmon.business.client.contact;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.GWTNamedEntity;
import java.util.Collection;

public interface ContactCodeProviderServiceAsync {
  public abstract void load(final AsyncCallback<Collection<GWTNamedEntity>> callback);
}
