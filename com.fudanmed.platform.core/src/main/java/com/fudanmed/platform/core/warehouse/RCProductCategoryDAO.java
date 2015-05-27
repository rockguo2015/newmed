package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductCategory;
import edu.fudan.mylang.pf.IBaseService;

public interface RCProductCategoryDAO extends IBaseService {
  public abstract RCProductCategory findByCode(final String code);
  
  public abstract Iterable<RCProductCategory> getAllToplevelCategories();
}
