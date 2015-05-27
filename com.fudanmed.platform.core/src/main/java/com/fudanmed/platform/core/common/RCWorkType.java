package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCWorkTypeImpl;
import com.fudanmed.platform.core.common.proxy.RCWorkTypeProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCWorkTypeImpl.class)
public interface RCWorkType extends Code {
  public abstract RCWorkTypeProxy toProxy();
}
