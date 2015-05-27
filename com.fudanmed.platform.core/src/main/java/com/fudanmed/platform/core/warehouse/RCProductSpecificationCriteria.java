package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import com.fudanmed.platform.core.warehouse.impl.RCProductSpecificationCriteriaImpl;
import edu.fudan.mylang.pf.query.IPagedCriteria;
import edu.fudan.mylang.pf.query.QueryImplementation;

@QueryImplementation(implementBy = RCProductSpecificationCriteriaImpl.class)
public interface RCProductSpecificationCriteria extends IPagedCriteria<RCProductSpecification> {
  public abstract String getInfo();
  
  public abstract RCProductSpecificationCriteria setInfo(final String info);
  
  public abstract RCProductCategory getCategory();
  
  public abstract RCProductSpecificationCriteria setCategory(final RCProductCategory category);
  
  public abstract String getCategoryPath();
  
  public abstract RCProductSpecificationCriteria setCategoryPath(final String categoryPath);
  
  public abstract void postInitialize();
}
