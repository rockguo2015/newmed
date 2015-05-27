package com.fudanmed.platform.core.measure.proxy;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.measure.RCElectricMeasureDevice")
public class RCElectricMeasureDeviceProxy extends RCMeasureDeviceProxy {
  public RCElectricMeasureDeviceProxy() {
    this.setClazzName("com.fudanmed.platform.core.measure.RCElectricMeasureDevice");
  }
}
