package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.impl.RCAcquireTypeImpl;
import com.fudanmed.platform.core.device.proxy.RCAcquireTypeProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCAcquireTypeImpl.class)
public interface RCAcquireType extends Code {
  public abstract RCAcquireTypeProxy toProxy();
}
