package com.fudanmed.platform.core.domain;

import com.fudanmed.platform.core.domain.RCEnterprise;
import com.fudanmed.platform.core.domain.RCSupplierType;
import com.fudanmed.platform.core.domain.impl.RCSupplierImpl;
import com.fudanmed.platform.core.domain.proxy.RCSupplierProxy;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCSupplierImpl.class)
public interface RCSupplier extends RCEnterprise {
  public abstract RCSupplierType getType();
  
  public abstract RCSupplier setType(final RCSupplierType type);
  
  public abstract RCSupplierProxy toProxy();
}
