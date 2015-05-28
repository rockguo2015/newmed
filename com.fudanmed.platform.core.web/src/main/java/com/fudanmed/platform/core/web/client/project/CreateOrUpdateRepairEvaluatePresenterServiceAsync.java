package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairEvaluateProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateRepairEvaluatePresenterServiceAsync {
  public abstract void loadValue(final RCRepairEvaluateProxy pvalue, final AsyncCallback<UIRepairEvaluate> callback);
  
  public abstract void updateValue(final UIRepairEvaluate uivalue, final AsyncCallback<Void> callback);
}
