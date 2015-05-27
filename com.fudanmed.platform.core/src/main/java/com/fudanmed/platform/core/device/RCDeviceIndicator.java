package com.fudanmed.platform.core.device;

import com.fudanmed.platform.core.device.impl.RCDeviceIndicatorImpl;
import com.fudanmed.platform.core.device.proxy.RCDeviceIndicatorProxy;
import edu.fudan.langlab.domain.code.Code;
import edu.fudan.mylang.pf.EntityImplementation;

@EntityImplementation(implementBy = RCDeviceIndicatorImpl.class)
public interface RCDeviceIndicator extends Code {
  public abstract RCDeviceIndicatorProxy toProxy();
}
