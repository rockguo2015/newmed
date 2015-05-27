package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductType;
import com.fudanmed.platform.core.warehouse.impl.RCProductTypeCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCProductTypeCriteriaImpl.class)
public interface RCProductTypeCriteria extends IPagedCriteria<RCProductType> {
  public abstract String getInfo();
  
  public abstract RCProductTypeCriteria setInfo(final String info);
}
