package com.fudanmed.platform.core.measure.proxy;

import com.fudanmed.platform.core.measure.proxy.RCMeasureDeviceTypeProxy;
import edu.fudan.mylang.pf.ProxyTarget;

@ProxyTarget("com.fudanmed.platform.core.measure.RCElectricMeasureDeviceType")
public class RCElectricMeasureDeviceTypeProxy extends RCMeasureDeviceTypeProxy {
  public RCElectricMeasureDeviceTypeProxy() {
    this.setClazzName("com.fudanmed.platform.core.measure.RCElectricMeasureDeviceType");
  }
}
