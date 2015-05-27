package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCSupplier;
import edu.fudan.mylang.pf.IBaseService;

public interface RCSupplierDAO extends IBaseService {
  public abstract RCSupplier findByName(final String name);
}
