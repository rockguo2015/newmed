package com.fudanmed.platform.core.measure.proxy;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice")
public class RCPhasedElectricMeasureDeviceProxy extends RCMeasureDeviceProxy {
  public RCPhasedElectricMeasureDeviceProxy() {
    this.setClazzName("com.fudanmed.platform.core.measure.RCPhasedElectricMeasureDevice");
  }
}
