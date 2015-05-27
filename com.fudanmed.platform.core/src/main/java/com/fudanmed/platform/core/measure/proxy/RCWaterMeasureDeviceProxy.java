package com.fudanmed.platform.core.measure.proxy;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.measure.RCWaterMeasureDevice")
public class RCWaterMeasureDeviceProxy extends RCMeasureDeviceProxy {
  public RCWaterMeasureDeviceProxy() {
    this.setClazzName("com.fudanmed.platform.core.measure.RCWaterMeasureDevice");
  }
}
