package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCOutStockTypeImpl;
import com.fudanmed.platform.core.common.proxy.RCOutStockTypeProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCOutStockTypeImpl.class)
public interface RCOutStockType extends Code {
  public abstract RCOutStockTypeProxy toProxy();
}
