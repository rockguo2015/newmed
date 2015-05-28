package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.domain.proxy.RCOrganizationProxy;
import com.fudanmed.platform.core.web.client.organization.EmployeeManagementView;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIEmployeeCriteria;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.inject.ImplementedBy;
import com.uniquesoft.gwt.client.common.RequestHandler;
import com.uniquesoft.gwt.client.common.RequestHandler1;
import com.uniquesoft.gwt.client.common.RequestHandler2;
import com.uniquesoft.gwt.client.common.Viewer;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import java.util.Collection;

@ImplementedBy(value = EmployeeManagementView.class)
public interface EmployeeManagementPresenterView extends Viewer {
  public abstract void showResults(final IPagedResult<UIEmployee> results);
  
  public abstract void showOutlineDatas(final Collection<UIOrganization> outlineDatas);
  
  public abstract void refresh();
  
  public abstract void createRequest(final RequestHandler1<RCOrganizationProxy> requestHandler);
  
  public abstract void importRequest(final RequestHandler requestHandler);
  
  public abstract void organizationSelected(final RequestHandler2<RCOrganizationProxy,UIEmployeeCriteria> requestHandler);
  
  public abstract void deleteRequest(final RequestHandler1<RCEmployeeProxy> requestHandler);
  
  public abstract void modifyRequest(final RequestHandler1<RCEmployeeProxy> requestHandler);
  
  public abstract void modifyDepartment(final RequestHandler1<RCEmployeeProxy> requestHandler);
  
  public abstract void assignRolesRequest(final RequestHandler1<RCEmployeeProxy> requestHandler);
  
  public abstract void resetPasswdRequest(final RequestHandler1<RCEmployeeProxy> requestHandler);
  
  public abstract void leaveJobRequest(final RequestHandler1<RCEmployeeProxy> requestHandler);
  
  public abstract void resumeJobRequest(final RequestHandler1<RCEmployeeProxy> requestHandler);
  
  public abstract void filterRequest(final RequestHandler1<UIEmployeeCriteria> requestHandler);
}
