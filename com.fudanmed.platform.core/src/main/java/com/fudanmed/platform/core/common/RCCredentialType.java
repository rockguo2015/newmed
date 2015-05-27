package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCCredentialTypeImpl;
import com.fudanmed.platform.core.common.proxy.RCCredentialTypeProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCCredentialTypeImpl.class)
public interface RCCredentialType extends Code {
  public abstract RCCredentialTypeProxy toProxy();
}
