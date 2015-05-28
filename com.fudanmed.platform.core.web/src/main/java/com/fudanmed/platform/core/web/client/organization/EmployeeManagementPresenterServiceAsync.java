package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIEmployeeCriteria;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import java.util.Collection;

public interface EmployeeManagementPresenterServiceAsync {
  public abstract void filter(final UIEmployeeCriteria uicriteria, final AsyncCallback<IPagedResult<UIEmployee>> callback);
  
  public abstract void delete(final RCEmployeeProxy value, final AsyncCallback<Void> callback);
  
  public abstract void getAllOrganization(final AsyncCallback<Collection<UIOrganization>> callback);
  
  public abstract void asUser(final RCEmployeeProxy employee, final AsyncCallback<UserProxy> callback);
  
  public abstract void leaveJob(final RCEmployeeProxy value, final AsyncCallback<Void> callback);
  
  public abstract void resumeJob(final RCEmployeeProxy value, final AsyncCallback<Void> callback);
}
