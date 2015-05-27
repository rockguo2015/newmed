package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCEmployeeCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCEmployeeCriteriaImpl.class)
public interface RCEmployeeCriteria extends IPagedCriteria<RCEmployee> {
  public abstract String getInfo();
  
  public abstract RCEmployeeCriteria setInfo(final String info);
  
  public abstract Boolean getIncludeLeaveEmployees();
  
  public abstract RCEmployeeCriteria setIncludeLeaveEmployees(final Boolean includeLeaveEmployees);
  
  public abstract String getOrgPath();
  
  public abstract RCEmployeeCriteria setOrgPath(final String orgPath);
  
  public abstract RCOrganization getOrganization();
  
  public abstract RCEmployeeCriteria setOrganization(final RCOrganization organization);
}
