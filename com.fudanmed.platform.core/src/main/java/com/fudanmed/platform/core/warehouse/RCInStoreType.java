package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.impl.RCInStoreTypeImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCInStoreTypeProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCInStoreTypeImpl.class)
public interface RCInStoreType extends Code {
  public abstract RCInStoreTypeProxy toProxy();
}
