package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.common.proxy.RCEBoardMessageProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UpdateEBoardMessageCommandServiceAsync {
  public abstract void loadEBoardMessage(final AsyncCallback<RCEBoardMessageProxy> callback);
}
