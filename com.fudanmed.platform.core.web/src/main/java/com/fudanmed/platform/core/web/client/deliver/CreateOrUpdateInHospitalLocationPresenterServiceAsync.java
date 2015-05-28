package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLInHospitalLocationProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIInHospitalLocation;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateInHospitalLocationPresenterServiceAsync {
  public abstract void loadValue(final DLInHospitalLocationProxy pvalue, final AsyncCallback<UIInHospitalLocation> callback);
  
  public abstract void updateValue(final UIInHospitalLocation uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIInHospitalLocation uivalue, final AsyncCallback<Void> callback);
}
