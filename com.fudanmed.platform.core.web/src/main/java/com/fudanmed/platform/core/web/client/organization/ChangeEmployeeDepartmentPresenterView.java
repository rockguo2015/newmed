package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.ChangeEmployeeDepartmentView;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.ViewerWithValidation;

@ImplementedBy(value = ChangeEmployeeDepartmentView.class)
public interface ChangeEmployeeDepartmentPresenterView extends ViewerWithValidation {
  public abstract RCOrganizationProxy getNewOrganization();
  
  public abstract void setOldOrganization(final UIOrganization oldOrg);
  
  public abstract void setOrganizationOutlinePresenter(final OrganizationOutlinePresenter organizationOutlinePresenter);
}
