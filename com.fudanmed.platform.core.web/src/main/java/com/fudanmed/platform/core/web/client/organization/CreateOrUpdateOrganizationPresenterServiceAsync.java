package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateOrganizationPresenterServiceAsync {
  public abstract void loadValue(final RCOrganizationProxy pvalue, final AsyncCallback<UIOrganization> callback);
  
  public abstract void updateValue(final UIOrganization uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final UIOrganization uivalue, final AsyncCallback<RCOrganizationProxy> callback);
}
