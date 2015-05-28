package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.CreateOrUpdateEmployeeView;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = CreateOrUpdateEmployeeView.class)
public interface CreateOrUpdateEmployeePresenterView extends ViewerWithValidation {
  public abstract UIEmployee getValue();
  
  public abstract void setValue(final UIEmployee value);
  
  public abstract void setOrganization(final RCOrganizationProxy org);
}
