package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverPatientCheckCategoryProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverPatientCheckCategory;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateDeliverPatientCheckCategoryPresenterServiceAsync {
  public abstract void loadValue(final DLDeliverPatientCheckCategoryProxy pvalue, final AsyncCallback<UIDeliverPatientCheckCategory> callback);
  
  public abstract void updateValue(final UIDeliverPatientCheckCategory uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final DLDeliverPatientCheckCategoryProxy parent, final UIDeliverPatientCheckCategory uivalue, final AsyncCallback<Void> callback);
}
