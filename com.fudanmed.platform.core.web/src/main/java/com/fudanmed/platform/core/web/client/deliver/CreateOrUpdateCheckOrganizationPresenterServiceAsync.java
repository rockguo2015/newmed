package com.fudanmed.platform.core.web.client.deliver;

import com.fudanmed.platform.core.deliver.proxy.DLCheckOrganizationProxy;
import com.fudanmed.platform.core.web.shared.deliver.UICheckOrganization;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateCheckOrganizationPresenterServiceAsync {
  public abstract void loadValue(final DLCheckOrganizationProxy pvalue, final AsyncCallback<UICheckOrganization> callback);
  
  public abstract void updateValue(final UICheckOrganization uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UICheckOrganization uivalue, final AsyncCallback<Void> callback);
}
