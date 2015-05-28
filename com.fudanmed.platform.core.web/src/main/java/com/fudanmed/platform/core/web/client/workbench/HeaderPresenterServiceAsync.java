package com.fudanmed.platform.core.web.client.workbench;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HeaderPresenterServiceAsync {
  public abstract void getAppTitle(final AsyncCallback<String> callback);
}
