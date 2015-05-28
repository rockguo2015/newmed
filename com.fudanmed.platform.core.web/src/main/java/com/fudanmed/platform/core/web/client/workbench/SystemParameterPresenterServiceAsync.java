package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SystemParameterPresenterServiceAsync {
  public abstract void loadParameter(final AsyncCallback<UISystemParameter> callback);
}
