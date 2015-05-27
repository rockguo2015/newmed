package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCOrganization;
import com.fudanmed.platform.core.domain.impl.RCOrganizationCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCOrganizationCriteriaImpl.class)
public interface RCOrganizationCriteria extends IPagedCriteria<RCOrganization> {
  public abstract String getInfo();
  
  public abstract RCOrganizationCriteria setInfo(final String info);
}
