package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLDeliverOrganizationProxy;
import com.fudanmed.platform.core.web.shared.deliver.UIDeliverOrganization;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateDeliverOrganizationPresenterServiceAsync {
  public abstract void loadValue(final DLDeliverOrganizationProxy pvalue, final AsyncCallback<UIDeliverOrganization> callback);
  
  public abstract void updateValue(final UIDeliverOrganization uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIDeliverOrganization uivalue, final AsyncCallback<Void> callback);
}
