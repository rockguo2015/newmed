package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairEvaluate;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ShowRepairEvaluatePresenterServiceAsync {
  public abstract void loadEvaluate(final RCRepairTaskProxy repairTask, final AsyncCallback<UIRepairEvaluate> callback);
}
