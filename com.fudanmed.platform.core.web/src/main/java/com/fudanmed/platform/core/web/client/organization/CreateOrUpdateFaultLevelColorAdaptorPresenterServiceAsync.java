package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.common.proxy.RCFaultLevelColorAdaptorProxy;
import com.fudanmed.platform.core.web.shared.organization.UIFaultLevelColorAdaptor;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateFaultLevelColorAdaptorPresenterServiceAsync {
  public abstract void loadValue(final RCFaultLevelColorAdaptorProxy pvalue, final AsyncCallback<UIFaultLevelColorAdaptor> callback);
  
  public abstract void updateValue(final UIFaultLevelColorAdaptor uivalue, final AsyncCallback<Void> callback);
}
