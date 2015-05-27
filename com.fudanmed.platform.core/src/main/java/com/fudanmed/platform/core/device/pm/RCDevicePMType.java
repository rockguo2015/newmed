package com.fudanmed.platform.core.device.pm;

import com.fudanmed.platform.core.device.pm.impl.RCDevicePMTypeImpl;
import com.fudanmed.platform.core.device.pm.proxy.RCDevicePMTypeProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCDevicePMTypeImpl.class)
public interface RCDevicePMType extends Code {
  public abstract RCDevicePMTypeProxy toProxy();
}
