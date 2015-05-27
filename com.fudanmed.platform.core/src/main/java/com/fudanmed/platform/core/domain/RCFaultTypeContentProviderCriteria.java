package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCFaultType;
import com.fudanmed.platform.core.domain.impl.RCFaultTypeContentProviderCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCFaultTypeContentProviderCriteriaImpl.class)
public interface RCFaultTypeContentProviderCriteria extends IPagedCriteria<RCFaultType> {
  public abstract String getName();
  
  public abstract RCFaultTypeContentProviderCriteria setName(final String name);
}
