package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCenterlizedDeliverTaskProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIPatientCheckDeliverTaskEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface PatientCheckDeliverTaskEventListPresenterServiceAsync {
  public abstract void loadPatientCheckDeliverTaskEventList(final DLCenterlizedDeliverTaskProxy context, final AsyncCallback<Collection<UIPatientCheckDeliverTaskEvent>> callback);
}
