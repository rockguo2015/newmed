package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface FaultLevelColorAdaptorListPresenterServiceAsync {
  public abstract void loadFaultLevelColorAdaptorList(final AsyncCallback<Collection<UIFaultLevelColorAdaptor>> callback);
}
