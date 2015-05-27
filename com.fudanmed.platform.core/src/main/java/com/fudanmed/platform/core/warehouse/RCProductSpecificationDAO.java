package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductSpecification;
import edu.fudan.mylang.pf.IBaseService;

public interface RCProductSpecificationDAO extends IBaseService {
  public abstract RCProductSpecification findBySid(final String sid);
  
  public abstract RCProductSpecification findByMaterialId(final String materialId);
}
