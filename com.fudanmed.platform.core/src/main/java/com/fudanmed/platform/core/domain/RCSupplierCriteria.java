package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCSupplier;
import com.fudanmed.platform.core.domain.RCSupplierType;
import com.fudanmed.platform.core.domain.impl.RCSupplierCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCSupplierCriteriaImpl.class)
public interface RCSupplierCriteria extends IPagedCriteria<RCSupplier> {
  public abstract String getInfo();
  
  public abstract RCSupplierCriteria setInfo(final String info);
  
  public abstract RCSupplierType getType();
  
  public abstract RCSupplierCriteria setType(final RCSupplierType type);
}
