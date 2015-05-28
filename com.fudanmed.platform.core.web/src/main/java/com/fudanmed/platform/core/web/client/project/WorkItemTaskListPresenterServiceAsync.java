package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCGroupTaskProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemTask;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WorkItemTaskListPresenterServiceAsync {
  public abstract void load(final RCGroupTaskProxy parent, final AsyncCallback<Collection<UIWorkItemTask>> callback);
}
