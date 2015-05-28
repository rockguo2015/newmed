package com.fudanmed.platform.core.web.client.device;

import com.fudanmed.platform.core.device.pm.proxy.RCPMWorkItemProxy;
import com.fudanmed.platform.core.web.shared.device.UIPMWorkItemTeamFinishReportData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreatePMWorkItemTeamFinishReportPresenterServiceAsync {
  public abstract void updateValue(final RCPMWorkItemProxy workItem, final UIPMWorkItemTeamFinishReportData uivalue, final AsyncCallback<Void> callback);
}
