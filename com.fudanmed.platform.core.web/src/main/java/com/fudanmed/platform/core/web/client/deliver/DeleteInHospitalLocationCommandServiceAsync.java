package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeleteInHospitalLocationCommandServiceAsync {
  public abstract void delete(final DLInHospitalLocationProxy value, final AsyncCallback<Void> callback);
}
