package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverTaskFinishData;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface CreateOrUpdateDeliverTaskFinishDataPresenterServiceAsync {
  public abstract void commit(final Collection<DLCenterlizedDeliverTaskProxy> deliverTasks, final UIDeliverTaskFinishData uivalue, final AsyncCallback<Void> callback);
}
