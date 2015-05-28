package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCWorkItemTaskProxy;
import com.fudanmed.platform.core.web.shared.project.WorkItemOutsourceData;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface WorkItemOutsourcePresenterServiceAsync {
  public abstract void commit(final RCWorkItemTaskProxy context, final WorkItemOutsourceData data, final AsyncCallback<Void> callback);
  
  public abstract void getComment(final RCWorkItemTaskProxy context, final AsyncCallback<String> callback);
}
