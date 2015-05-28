package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CreateOrUpdateEmployeePresenterServiceAsync {
  public abstract void loadValue(final RCEmployeeProxy pvalue, final AsyncCallback<UIEmployee> callback);
  
  public abstract void updateValue(final UIEmployee uivalue, final AsyncCallback<Void> callback);
  
  public abstract void createValue(final RCOrganizationProxy org, final UIEmployee uivalue, final AsyncCallback<Void> callback);
}
