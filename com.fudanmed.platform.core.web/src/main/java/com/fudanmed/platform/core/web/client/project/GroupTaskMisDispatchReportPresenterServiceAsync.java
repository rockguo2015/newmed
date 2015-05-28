package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.web.shared.project.GroupTaskMisDispatchReportData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GroupTaskMisDispatchReportPresenterServiceAsync {
  public abstract void commit(final RCGroupTaskProxy context, final GroupTaskMisDispatchReportData data, final AsyncCallback<Void> callback);
}
