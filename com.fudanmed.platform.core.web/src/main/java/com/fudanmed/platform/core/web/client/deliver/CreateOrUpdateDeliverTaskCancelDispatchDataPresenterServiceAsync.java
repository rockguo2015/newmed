package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverTaskCancelDispatchData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface CreateOrUpdateDeliverTaskCancelDispatchDataPresenterServiceAsync {
  public abstract void commit(final Collection<DLCenterlizedDeliverTaskProxy> deliverTasks, final UIDeliverTaskCancelDispatchData uivalue, final AsyncCallback<Void> callback);
}
