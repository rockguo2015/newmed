package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.shared.deliver.DeliverTaskDispatchData;
import com.fudanmed.platform.core.web.shared.deliver.UICenterlizedDeliverTask;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface DeliverTaskDispatchPresenterServiceAsync {
  public abstract void commit(final Collection<DLCenterlizedDeliverTaskProxy> context, final DeliverTaskDispatchData data, final AsyncCallback<Void> callback);
  
  public abstract void resolveTasks(final Collection<DLCenterlizedDeliverTaskProxy> tasks, final AsyncCallback<Collection<UICenterlizedDeliverTask>> callback);
}
