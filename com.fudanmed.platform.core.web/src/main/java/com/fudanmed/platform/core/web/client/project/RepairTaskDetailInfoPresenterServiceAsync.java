package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairTask;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RepairTaskDetailInfoPresenterServiceAsync {
  public abstract void loadRepairTask(final RCRepairTaskProxy repairTask, final AsyncCallback<UIRepairTask> callback);
}
