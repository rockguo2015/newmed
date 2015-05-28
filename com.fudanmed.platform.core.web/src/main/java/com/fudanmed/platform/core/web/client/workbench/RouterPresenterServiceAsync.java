package com.fudanmed.platform.core.web.client.workbench;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RouterPresenterServiceAsync {
  public abstract void isReporter(final AsyncCallback<Boolean> callback);
}
