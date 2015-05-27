package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.impl.RCDeviceUsageTypeImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceUsageTypeProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCDeviceUsageTypeImpl.class)
public interface RCDeviceUsageType extends Code {
  public abstract RCDeviceUsageTypeProxy toProxy();
}
