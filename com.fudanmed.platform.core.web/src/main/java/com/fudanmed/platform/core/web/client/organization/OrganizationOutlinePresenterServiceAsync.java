package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Collection;

public interface OrganizationOutlinePresenterServiceAsync {
  public abstract void loadAllOrganization(final AsyncCallback<Collection<UIOrganization>> callback);
  
  public abstract void getValue(final RCOrganizationProxy org, final AsyncCallback<UIOrganization> callback);
}
