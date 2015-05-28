package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCRepairTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIRepairDispatchData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RepairDispatchPresenterServiceAsync {
  public abstract void dispatch(final RCRepairTaskProxy report, final UIRepairDispatchData data, final AsyncCallback<Void> callback);
  
  public abstract void getSystemUser(final AsyncCallback<RCEmployeeProxy> callback);
}
