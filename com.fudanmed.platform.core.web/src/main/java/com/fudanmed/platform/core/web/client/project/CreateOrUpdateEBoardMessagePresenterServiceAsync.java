package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import com.fudanmed.platform.core.web.shared.project.UIEBoardMessage;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateEBoardMessagePresenterServiceAsync {
  public abstract void loadValue(final RCEBoardMessageProxy pvalue, final AsyncCallback<UIEBoardMessage> callback);
  
  public abstract void updateValue(final UIEBoardMessage uivalue, final AsyncCallback<Void> callback);
}
