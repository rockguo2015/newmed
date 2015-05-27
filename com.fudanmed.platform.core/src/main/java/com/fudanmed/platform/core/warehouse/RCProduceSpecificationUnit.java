package com.fudanmed.platform.core.warehouse;

import com.fudanmed.platform.core.warehouse.impl.RCProduceSpecificationUnitImpl;
import com.fudanmed.platform.core.warehouse.proxy.RCProduceSpecificationUnitProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCProduceSpecificationUnitImpl.class)
public interface RCProduceSpecificationUnit extends Code {
  public abstract RCProduceSpecificationUnitProxy toProxy();
}
