package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCOnsitePosition;
import com.fudanmed.platform.core.domain.impl.RCOnsitePositionCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCOnsitePositionCriteriaImpl.class)
public interface RCOnsitePositionCriteria extends IPagedCriteria<RCOnsitePosition> {
  public abstract String getInfo();
  
  public abstract RCOnsitePositionCriteria setInfo(final String info);
}
