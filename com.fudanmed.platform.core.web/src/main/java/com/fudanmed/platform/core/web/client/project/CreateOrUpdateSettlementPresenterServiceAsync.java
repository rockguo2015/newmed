package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.shared.project.UISettlement;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateSettlementPresenterServiceAsync {
  public abstract void loadValue(final RCSettlementProxy pvalue, final AsyncCallback<UISettlement> callback);
  
  public abstract void updateValue(final UISettlement uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UISettlement uivalue, final AsyncCallback<Void> callback);
}
