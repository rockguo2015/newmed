package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCFaultTypeProxy;
import com.fudanmed.platform.core.domain.proxy.RCMaintenamceTypeProxy;
import com.fudanmed.platform.core.web.shared.project.UIFaultType;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateFaultTypePresenterServiceAsync {
  public abstract void loadValue(final RCFaultTypeProxy pvalue, final AsyncCallback<UIFaultType> callback);
  
  public abstract void updateValue(final UIFaultType uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final RCMaintenamceTypeProxy parent, final UIFaultType uivalue, final AsyncCallback<Void> callback);
}
