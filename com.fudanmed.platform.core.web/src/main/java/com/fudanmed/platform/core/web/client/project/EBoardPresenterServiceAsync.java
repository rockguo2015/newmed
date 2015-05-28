package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.web.shared.project.EBoardResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EBoardPresenterServiceAsync {
  public abstract void loadRefreshInterval(final AsyncCallback<Integer> callback);
  
  public abstract void loadActiveTasks(final Integer requestPage, final AsyncCallback<EBoardResult> callback);
}
