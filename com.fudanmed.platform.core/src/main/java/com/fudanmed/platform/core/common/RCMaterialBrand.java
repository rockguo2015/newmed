package com.fudanmed.platform.core.common;

import com.fudanmed.platform.core.common.impl.RCMaterialBrandImpl;
import com.fudanmed.platform.core.common.proxy.RCMaterialBrandProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCMaterialBrandImpl.class)
public interface RCMaterialBrand extends Code {
  public abstract RCMaterialBrandProxy toProxy();
}
