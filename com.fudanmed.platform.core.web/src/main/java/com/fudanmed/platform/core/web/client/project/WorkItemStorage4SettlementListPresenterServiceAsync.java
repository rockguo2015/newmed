package com.fudanmed.platform.core.web.client.project;

import com.fudanmed.platform.core.domain.proxy.RCSettlementProxy;
import com.fudanmed.platform.core.web.shared.project.UIWorkItemStorage4Settlement;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface WorkItemStorage4SettlementListPresenterServiceAsync {
  public abstract void loadWorkItemStorageList4Settlement(final RCSettlementProxy context, final AsyncCallback<Collection<UIWorkItemStorage4Settlement>> callback);
  
  public abstract void prepareExport(final RCSettlementProxy context, final AsyncCallback<String> callback);
}
