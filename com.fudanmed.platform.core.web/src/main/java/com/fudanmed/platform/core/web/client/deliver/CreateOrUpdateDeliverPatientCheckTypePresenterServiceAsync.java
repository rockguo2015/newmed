package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckTypeProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckType;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateDeliverPatientCheckTypePresenterServiceAsync {
  public abstract void loadValue(final DLDeliverPatientCheckTypeProxy pvalue, final AsyncCallback<UIDeliverPatientCheckType> callback);
  
  public abstract void updateValue(final UIDeliverPatientCheckType uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIDeliverPatientCheckType uivalue, final DLDeliverPatientCheckCategoryProxy parent, final AsyncCallback<Void> callback);
}
