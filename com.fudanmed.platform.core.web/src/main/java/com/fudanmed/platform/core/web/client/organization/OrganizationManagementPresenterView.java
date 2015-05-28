package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.OrganizationManagementView;
import com.fudanmed.platform.core.web.client.organization.OrganizationOutlinePresenter;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.Viewer;

@ImplementedBy(value = OrganizationManagementView.class)
public interface OrganizationManagementPresenterView extends Viewer {
  public abstract void setOrganizationOutlinePresenter(final OrganizationOutlinePresenter organizationOutlinePresenter);
  
  public abstract void createRequest(final RequestHandler1<RCOrganizationProxy> requestHandler);
  
  public abstract void importRequest(final RequestHandler requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCOrganizationProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCOrganizationProxy> requestHandler);
}
