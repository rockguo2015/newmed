package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.RCProductType;
import edu.fudan.mylang.pf.IBaseService;

public interface RCProductTypeDAO extends IBaseService {
  public abstract RCProductType findByCode(final String code);
}
