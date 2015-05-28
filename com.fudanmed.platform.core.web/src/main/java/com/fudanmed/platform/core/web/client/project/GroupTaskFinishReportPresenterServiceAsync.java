package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.web.shared.project.GroupTaskFinishReportData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GroupTaskFinishReportPresenterServiceAsync {
  public abstract void commit(final RCGroupTaskProxy context, final GroupTaskFinishReportData data, final AsyncCallback<Void> callback);
}
