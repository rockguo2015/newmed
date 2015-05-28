package com.fudanmed.platform.core.web.client.organization;

import com.fudanmed.platform.core.domain.proxy.RCEmployeeProxy;
import com.fudanmed.platform.core.web.shared.organization.UIEmployee;
import com.fudanmed.platform.core.web.shared.organization.UIEmployeeCriteria;
import com.fudanmed.platform.core.web.shared.organization.UIOrganization;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;
import com.uniquesoft.gwt.shared.common.pager.IPagedResult;
import com.uniquesoft.gwt.shared.validation.ValidationException;
import edu.fudan.langlab.domain.security.proxy.UserProxy;
import java.util.Collection;

@RemoteServiceRelativePath("service/com.fudanmed.platform.core.web.client.organization.EmployeeManagementPresenterService")
public interface EmployeeManagementPresenterService extends RemoteService {
  public abstract IPagedResult<UIEmployee> filter(final UIEmployeeCriteria uicriteria) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void delete(final RCEmployeeProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract Collection<UIOrganization> getAllOrganization() throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract UserProxy asUser(final RCEmployeeProxy employee) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void leaveJob(final RCEmployeeProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
  
  public abstract void resumeJob(final RCEmployeeProxy value) throws SessionTimeOutException, ValidationException, DataBaseConstraintException;
}
