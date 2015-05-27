package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEmployee;
import com.fudanmed.platform.core.domain.impl.RCEmployeeByNameCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCEmployeeByNameCriteriaImpl.class)
public interface RCEmployeeByNameCriteria extends IPagedCriteria<RCEmployee> {
  public abstract String getName();
  
  public abstract RCEmployeeByNameCriteria setName(final String name);
  
  public abstract Boolean getIsLeaveJob();
  
  public abstract RCEmployeeByNameCriteria setIsLeaveJob(final Boolean isLeaveJob);
  
  public abstract void initialize();
}
