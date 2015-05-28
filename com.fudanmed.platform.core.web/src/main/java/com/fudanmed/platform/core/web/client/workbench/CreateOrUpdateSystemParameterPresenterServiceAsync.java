package com.fudanmed.platform.core.web.client.workbench;

import com.fudanmed.platform.core.web.shared.workbench.UISystemParameter;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateSystemParameterPresenterServiceAsync {
  public abstract void loadValue(final AsyncCallback<UISystemParameter> callback);
  
  public abstract void updateValue(final UISystemParameter uivalue, final AsyncCallback<Void> callback);
}
